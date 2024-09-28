package employee.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import employee.exception.EmployeeException;
import employee.model.dao.EmployeeDao;
import employee.model.dto.Employee;

import static common.JDBCTempleate.*; //JDBCTemplate 이 가진 모든 static 메소드를 임포트

//Connection 관리와 트랜잭션 관리가 주 목적인 서비스 모델
public class EmployeeService {
	private EmployeeDao edao;
	
	public EmployeeService() throws EmployeeException {
		edao = new EmployeeDao();
	}
	
	//1
	public ArrayList<Employee> selectAll() throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee>list = edao.selectAll(conn);
		close(conn);
		return list;
	}
	
	//7
	public ArrayList<Employee> selectJob(String jobId) throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee>list = edao.selectJob(conn, jobId);
		close(conn);
		return list;
	}
	
	//6
	public ArrayList<Employee> selectDept(String deptId) throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee>list = edao.selectDept(conn, deptId);
		close(conn);
		return list;
	}
	
	//2
	public Employee selectOne(String empId) throws EmployeeException{
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empId);
		close(conn);
		return emp;
	}
	
	//3
	public int insertEmployee(Employee emp) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.insertEmployee(conn, emp);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}close(conn);
		return result;
	}
	
	//4
	public int updateEmployee(Employee emp) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.updateEmployee(conn,emp);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}close(conn);
		return result;
	}
	
	//5
	public int deleteEmployee(String empId) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.deleteEmployee(conn,empId);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}close(conn);
		return result;
	}
}
