package employee.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.dto.Employee;
import static common.JDBCTempleate.*;

//서비스 모델 : 비스니스 로직(jdbc) 처리용 클래스
//dao(database access object) : db 접속 객체
public class EmployeeDao {
	// 실행시킬 쿼리문장 하나당 메소드 한개씩 작성함
//	System.out.println("1. 직원 전체 조회 출력");
	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> list = null;
		String query = "select * from employee";

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Employee>();
				while(rset.next()) {	//조회해온 데이터 행이 존재한다면
					//각 컬럼 값 꺼내서 객체에 저장처리
					Employee emp = new Employee();
					
					//결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
					emp.setEmpId(rset.getString("emp_id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNo(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getNString("phone"));
					emp.setJobId(rset.getString("job_id"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrId(rset.getString("mgr_id"));
					emp.setDeptId(rset.getString("dept_id"));
					
					list.add(emp);
				}//while
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

//	System.out.println("2. 사번으로 직원 조회 출력");
	public Employee selectOne(String empId) {
		Employee emp = null;
		String query = "select * from employee where emp_id =?";

		Connection conn = getConnection();
		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//stmt = conn.createStatement();
			stmt=conn.prepareStatement(query);	//미완성 쿼리문을 가지고 문장객체 생성함
			//?부분에 적용할 값 대입처리 : 쿼리문 완성시킴
			//stmt.set자료형(?순번, 적용할값);
			stmt.setString(1, empId);
			
//			rset = stmt.executeQuery(query);
			rset=stmt.executeQuery();//쿼리문을 문장객체가 가지고 있으므로 빈괄호로 실행
			
			if(rset.next()) {	//조회해온 데이터 행이 존재한다면
				//각 컬럼 값 꺼내서 객체에 저장처리
				emp = new Employee();
				
				//결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
				emp.setEmpId(empId);
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNo(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getNString("phone"));
				emp.setJobId(rset.getString("job_id"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	//	System.out.println("3. 새 직원 등록");
	public int insertEmployee(Employee emp) {
		int result = 0;
		String query = "insert into employee (emp_id, emp_name,emp_no,email,phone,"
				+ "job_id,salary,bonus_pct,marriage,mgr_id,hire_date,dept_id)" + "values (seq_empid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = getConnection();
//		Statement stmt = null;
		PreparedStatement stmt = null;
		
		try {
			//stmt = conn.createStatement();
			stmt = conn.prepareStatement(query);
			//?에 값 대입
			stmt.setString(1, emp.getEmpName());
			stmt.setString(2, emp.getEmpNo());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getPhone());
			stmt.setString(5, emp.getJobId());
			stmt.setInt(6, emp.getSalary());
			stmt.setDouble(7, emp.getBonusPct());
			stmt.setString(8, emp.getMarriage());
			stmt.setString(9, emp.getMgrId());
			stmt.setDate(10, emp.getHireDate());
			stmt.setString(11, emp.getDeptId());
			
			//result = stmt.executeUpdate(query);
			result =stmt.executeUpdate();
			
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//	System.out.println("4. 직원 정보 수정");
	public int updateEmployee(Employee emp) {
		int result = 0;
		String query = "update employee set	salary =? , bonus_pct =?"
				+ "where emp_id =?";
		Connection conn = getConnection();
//		Statement stmt = null;
		PreparedStatement stmt=null;

		try {
//			stmt = conn.createStatement();
			stmt=conn.prepareStatement(query);
			stmt.setInt(1, emp.getSalary());
			stmt.setDouble(2, emp.getBonusPct());
			stmt.setString(3,emp.getEmpId());
			
			
			result = stmt.executeUpdate(query);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			close(stmt);
			close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//	System.out.println("5. 직원 삭제");
	public int deleteEmployee(String empId) {
		int result = 0;
		String query = "delete from employee where emp_id =?";
		Connection conn = getConnection();
//		Statement stmt = null;
		PreparedStatement stmt=null;
		try {
//			stmt = conn.createStatement();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, empId);
			
			
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

//	System.out.println("6. 부서로 조회");
	public ArrayList<Employee> selectDept(String deptId) {
		ArrayList<Employee> list = null;
		String query = "select * from employee where dept_id = '" + deptId + "'";
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Employee>();
				while(rset.next()) {	//조회해온 데이터 행이 존재한다면
					//각 컬럼 값 꺼내서 객체에 저장처리
					Employee emp = new Employee();
					
					//결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
					emp.setEmpId(rset.getString("emp_id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNo(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getNString("phone"));
					emp.setJobId(rset.getString("job_id"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrId(rset.getString("mgr_id"));
					emp.setDeptId(rset.getString("dept_id"));
					
					list.add(emp);
				}//while
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

//	System.out.println("7. 직급으로 조회");
	public ArrayList<Employee> selectJob(String jobId) {
		ArrayList<Employee> list = null;
		String query = "select * from employee where job_id = '" + jobId + "'";
		Connection conn = getConnection();
//		Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
//			stmt = conn.createStatement();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, query);
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Employee>();
				while(rset.next()) {	//조회해온 데이터 행이 존재한다면
					//각 컬럼 값 꺼내서 객체에 저장처리
					Employee emp = new Employee();
					
					//결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
					emp.setEmpId(rset.getString("emp_id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNo(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getNString("phone"));
					emp.setJobId(rset.getString("job_id"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrId(rset.getString("mgr_id"));
					emp.setDeptId(rset.getString("dept_id"));
					
					list.add(emp);
				}//while
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
