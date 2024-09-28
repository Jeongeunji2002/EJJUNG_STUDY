package employee.view;

import java.util.ArrayList;
import java.util.Scanner;

import employee.controller.EmployeeController;
import employee.model.dto.Employee;

public class EmployeeMenu {
	// 의존성 주입 (DI : dependency Injection)
	private EmployeeController econtroller = new EmployeeController();
	private Scanner sc = new Scanner(System.in);

	public void display() {
		do {
			System.out.println("\n***** 직원 관리 프로그램 *****\n");

			System.out.println("1. 직원 전체 조회 출력");
			System.out.println("2. 사번으로 직원 조회 출력");
			System.out.println("3. 새 직원 등록");
			System.out.println("4. 직원 정보 수정");
			System.out.println("5. 직원 삭제");
			System.out.println("6. 부서로 조회");
			System.out.println("7. 직급으로 조회");
			System.out.println("9. 프로그램 종료");

			System.out.println("번호 입력 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				printList(econtroller.selectList());
				break;
			case 2:
				System.out.println(econtroller.selectEmp(inputEmpId()));
				break;
			case 3: econtroller.insertEmp(inputEmp()); break;
			case 4: econtroller.updateEmp(modifyEmp()); break;
			case 5: 
				if(econtroller.deleteEmp(inputEmpId()) > 0) {
					System.out.println("성공!");
				} else {
					System.out.println("실패!");					
				}
				break;
			case 6: printList(econtroller.selelctDept(inputDeptId())); break;
			case 7: printList(econtroller.selectJob(inputJobId())); break;
			case 9:
				System.out.println("정말 종료하시겠습니까? ( Y | N )");
				if (sc.next().toUpperCase().charAt(0) == 'Y') {
					return; // main()으로 돌려보냄
				} else {
					break; // switch 문을 바져나감
				}
			default:
				System.out.println("잘못된 번호입니다. 확인하고 다시 입력해주시길 바랍니다.");
			}

		} while (true);
	}// display()

	// 라스트 출력용 메소드
	public void printList(ArrayList<Employee> list) {
		System.out.println("\n직원수 : " + list.size() + "명");
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	// 사번 입력용 메소드
	public String inputEmpId() {
		System.out.println("\n조회 또는 삭제할 사번 : ");
		return sc.next();
	}

	// 부서코드 입력용 메소드
	public String inputDeptId() {
		System.out.println("\n조회할 부서 번호 : ");
		return sc.next();
	}

	// 직급코드 입력용 메소드
	public String inputJobId() {
		System.out.println("\n조회할 직급 번호 : ");
		return sc.next().toUpperCase();
	}
	//수정할 직원 정보 입력용 메소드
	public Employee modifyEmp() {
		Employee emp = new Employee();
		
		System.out.println("수정할 직원 사번 : ");
		emp.setEmpId(sc.next());
		System.out.println("수정할 급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.println("수정할 보너스포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		
		return emp;
	}
	//새 직원 정보 입력용 메소드
	public Employee inputEmp() {
		Employee emp = new Employee();
		
		System.out.println("이름 : ");
		emp.setEmpName(sc.next());
		System.out.println("주민번호 : ");
		emp.setEmpNo(sc.next());
		System.out.println("이메일 : ");
		emp.setEmail(sc.next());
		System.out.println("전화번호 [- 빼고 입력] : ");
		emp.setPhone(sc.next());
		System.out.println("급여 : ");
		emp.setSalary(sc.nextInt());
		System.err.println("보너스포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		System.out.println("직급코드 [J1~J7] : ");
		emp.setJobId(sc.next().toUpperCase());
		System.out.println("부서코드 : ");
		emp.setDeptId(sc.next());
		System.out.println("결혼여부 [기혼: Y, 미혼: N] : ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.println("관리자 사번 :");
		emp.setMgrId(sc.next());
		System.out.println("입사일 [yyyy-MM-dd] : ");
		emp.setHireDate(java.sql.Date.valueOf(sc.next()));
		return emp;
	}
}
