package oop.encapsulation;

//import java.sql.Date;
//import java.util.Date; // 이름이 같은 클래스는 둘 다 임포트할 수 없음 : 에러발생

// 자바에서 만드는 모든 클래스는 자동으로 java.lang.Object 의 후손이 되도록 되어 있음
// java.lang.Object 가 제공하는 메소드들을 후손이 자신의 것처럼 사용해도 됨
// 부모(super)가 제공하는 메소드를 후손(sub)이 상속받은 부모메소드를 내용바꾸기할 수 있다
// 오버라이딩 : 후손이 부모메소드 재작성하는 것을 말함
public class Employee {
	// Field (멤버변수) : 캡슐화가 원칙임 (private 이어야 함)
	// 접근제한자 [예약어] 자료형 변수명 [= 초기값];
	// 인스턴스 변수 (instance variable) : new 할때(생성자로 객체 생성할 때, 
	//						heap 메모리에 객체공간(인스턴스)을 만들면서 객체 공간 안에 할당되는 변수를 말함) (자동 초기화됨)
	private String  empId;	// 사번
	private String empName; // 이름
	private int salary; // 급여
	private double bonusPct; // 보너스포인트
	private java.sql.Date hireDate; // 입사일
	
	// 클래스 변수 (class variable) : 프로그램이 실행될 때(main() 이 start 될 때)
	//					자동으로 정적 메모리에 변수 공간을 할당하고 자동 초기화됨. (JVM이 준비해 놓은 기본값으로)
	private static int count;
	
	// 상수 변수 (constant variable) : 초기값 대입하고 값 변경 불가능인 필드
	// static 메모리에 할당된 변수는 프로그램 구동 내내 존재함 => 프로그램이 끝날 때(main 종료시) 자동 소멸됨
	// naming rule : 대문자로만 이름을 정의함
	public final static String OFFICE_NAME = "한국인공지능개발회사";
	
	// 이름이 같은 클래스를 구분해서 사용하려면, 클래스명 앞에 패키지명을 붙이면 됨 : 패키지명.클래스명
	// 단, 이 경우 생성자 앞에도 패키지명 붙여줘야 함
	//	private java.sql.Date hireDate = new java.sql.Date(0);
	//	private java.util.Date enrollDate = new java.util.Date();
	
	// Constructor
	
	// Method
	
	// getters and setters
	
	// 일반 메소드
	// java.lang.Object 가 제공하는 toString() 메소드 오버라이딩함 : 원래 기능은 "객체클래스명@16진수위치값" 리턴
	// 주로 후손 필드값 출력을 위한 문장만들기로 내용 변경하기 위해 오버라이딩함
	// 오버라이딩 규칙 1 : 부모 메소드의 시그니쳐 바꿀 수 없음 (그대로 사용)
	//Method (멤버함수)
    //getters and setters
    //인스턴스 필드
    //publivc void set필드명(필드자료형 매개변수) { this.필드명 = 매개변수;}
    public void setEmpld(String empld) {
        this.empId = empld;
    }
    
    //public 필드자료형 get필드명(){ return this.필드명;}
    public String getEmpld() {
        return this.empId;
    }
    
    //클래스 필드
    //static 필드는 getter, setter 에도 static 표기해야함
    //public static void set필드명(자료형 매개변수 { [클래스명.]필드명 = 매개변수;}
    public static void setCount(int newCount) {
        //static 메소드 안에는 this 레퍼런스가 없음
        Employee.count = count;
    }
    
    //public static 자료형 get필드명(){ return 필드명;}
    public static int getCount() {
        return Employee.count;
    }
    
    
    //일반 메소드
    //java.lang.Object 가 제공하는 toString() 메소드 오버라이딩함 : 원래 기능은 "객체클래스명@16진수위치값" 리턴
    //주로 후손 필드값 출력을 위한 문장만들기로 내용 변경하기 위해 오버라이딩함
    //오버라이딩 규칙 1: 부모 메소드의 시그니쳐 바꿀 수 없음(그대로 사용)
    public String toString() {
//        non-static 메소드는 this 레퍼런스를 가지고 있음
//        메소드가 실행될 때, 레퍼런스.메소드명() 실행시 레퍼런스가 가진 주소를 메소드 안의 this가 자동 전달받음
        return "Emplayee [사번= "+this.empId +", 이름= "+this.empName
                +", 급여= "+this.salary+", 보너스포인트= "+this.bonusPct
                +", 입사일 ="+this.hireDate+"]";
    }
}
