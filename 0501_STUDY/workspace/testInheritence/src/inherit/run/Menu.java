package inherit.run;

import com.practice1.model.vo.Book;
import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Rectangle;
import com.uni.Student;

import inherit.sample.Point;
import inherit.sample.Shape;
import oop.encapsulation.Employee;

public class Menu {
	
	// static (정적 메모리 : 메모리 영역의 크기가 고정된 메모리 영역)
	// 실행될 때 메모리에 로드되어 기록되는 위치가 정적 메모리에 할당한다는 의미임
	// static 은 프로그램이 실행될 때(main 이 start 될 때) 자동으로 메모리에 기록할당됨
	// 프로그램 종료(main 종료)시 자동 삭제됨 => 프로그램 구동되는 동안에는 계속 존재함 (객체간 자원 공유시 이용)
//	public static int value = 123;
//	public static String value2 = "정적메모리";
	
	public static void display() {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		do {
			System.out.println("\n*** 상속 테스트 ***\n");
			System.out.println("1. this 레퍼런스 객체 인스턴스 주소 전달 확인");
			System.out.println("2. equals() 오버라이딩 확인");
			System.out.println("3. clone() 오버라이딩 확인");
			System.out.println("4. 상속 확인 : Shape");
			System.out.println("5. 상속 실습2 : Student");
			System.out.println("6. 상속 실습1-1 : Book 메소드 오버라이딩");
			System.out.println("7. 상속 실습1-2 : 여러 후손에 대한 객체 배열");
			System.out.println("8. 객체지향 캡슐화 연습 : 생성자, 초기화블럭");
			System.out.println("9. 상속 실습1-3 : 다형성");
			System.out.println("0. 프로그램 끝내기");
			
			System.out.println("선택 번호 입력 : ");
			int no = scan.nextInt();
			
			switch(no) {
				case 1: 
					testThis();
					break;
				case 2:
					testEquals();
					break;
				case 3:
					testClone();
					break;
				case 4:
					testShape();
					break;
				case 5:
					testStudent();
					break;
				case 6:
					testBook();
					break;
				case 7:
					testObjectArray();
					break;
				case 8:
					testEnCapsulation();
					break;
				case 9:
					testPointArray();
					break;
				case 0: 
					System.out.println("정말로 종료하시겠습니까? (종료: y, 취소 : n) >>> ");
					if(scan.next().toUpperCase().charAt(0) == 'Y') {
						return; //main() 으로 돌려보냄 => 프로그램 종료
					} else {
						break; //switch 를 끝냄
					}
				default: System.out.println("잘못 입력하셨습니다. 확인하고 다시 입력하세요.");
			}
		} while(true);
	} // display()
	
	private static void testThis() {
		Point p1 = new Point(); // 힙 메모리에 객체 생성하고, 그 주소를 p1에 기록함
		// 객체 생성시 자동 실행된 생성자 안에 this 레퍼런스도 자동으로 객체의 주소를 전달받게 됨
		System.out.println("p1이 가진 객체의 주소 : "+p1.hashCode()); // 824208363
		System.out.println("p1이 참조하는 객체 안의 인스턴스 변수값 확인" + p1.toString());
		// 레퍼런스.메소드명() 실행하면, 레퍼런스가 가진 객체주소를 메소드 안의 this 에게 자동 전달되게 됨
		
		System.out.println("Object 의 toString() : " + new Object().toString());
	}
	
	private static void testEquals() {
		Point p1 = new Point(10, 10);
		System.out.println("p1 이 가진 주소 : " + p1.hashCode()); // 824208363
		System.out.println("p1이 참조하는 객체 안의 필드값 : " + p1/* .toString() */);
		Point p2 = new Point(20, 20);
		System.out.println("p2 가 가진 주소 : " + p2.hashCode()); // 624271064
		System.out.println("p2가 참조하는 객체 안의 필드값 : " + p2/* .toString() */);
		Point p3 = p1;
		System.out.println("p3 이 가진 주소 : " + p3.hashCode()); // shallow copy (얕은 복사) : 주소 복사
		
		
		System.out.println("두 객체가 가진 값들이 일치하느냐 : " + p1.equals(p2)); // false
		System.out.println("두 객체가 가진 값들이 일치하느냐 : " + p1.equals(p3)); // true
	}
	
	private static void testClone() {
		Point p1 = new Point(100, 100);
		System.out.println("p1 이 가진 주소 : " + p1.hashCode()); // 주소 : 824208363
		
		Point p2 = (Point)p1.clone(); // 리턴타입 Object => Point 로 형변환함
		// 다형성 : 부모(Object)가 여러 후손타입을 받을 수 있다.
		// 후손은 부모 타입을 못 받음 => 상속관계에 있으면 형변환 가능함
		System.out.println("p2 가 가진 주소 : " + p2.hashCode()); // 주소 : 624271064
		
		System.out.println("p1 필드값 : "+p1);
		System.out.println("p2 필드값 : "+p2);

		System.out.println("값 비교 : " + p1.equals(p2)); // true
		System.out.println("주소 비교 : " + (p1 == p2)); // false
	}
	
	private static void testShape() {
		Shape s = new Shape();
		System.out.println("s가 가진 주소 : " + s.hashCode()); // 1048027629
		System.out.println("s가 참조 객체 필드값 : " + s); // area = 0.0, perimeter = 0.0
		
		// 부모 멤버는 후손이 사용할 수 있다.
		s.setX(120);
		s.setY(230);
		System.out.println("값 확인 : " + s.getX() + ", " + s.getY()); // 값 확인 : 120.0, 230.0
		
		// super() 이용해서 부모의 매개변수 있는 생성자로 초기값 전달 확인
		
		Shape s2 = new Shape(10, 10, 100, 100);
		System.out.println("s2 : " + s2 /* .toString */);
	}
	
	private static void testStudent() {
		// 상속 실습문제2
		// 객체 배열 : Student 객체 3개 초기화 생성
		Student arrays [] = new Student[3];
		arrays[0] = new Student("홍길동",15,171,81,"201101","영문");
		arrays[1] = new Student("한사람",13,183,72,"201102","건축");
		arrays[2] = new Student("임걱정",16,175,65,"201103","무영");
		// Student 객체를 3개 생성하여 배열에 넣는다.
		
		for (int i = 0; i < arrays.length; i++) {
			System.out.println(arrays[i].printInformation());
		}
		// 배열에 있는 객체 정보를 모두 출력 한다. - for 문 이용 할 것
	}
	
	private static void testBook() {
		// 초기값을 부여한 두 개의 객체를 생성함
		Book b1 = new Book("자바의 정석", "홍길동", 75000);
		Book b2 = new Book("SQL을 정복하라","고길동",50000);
		
		// 두 객체의 정보 출력 처리함  :  toString() 사용
		System.out.println("b1 : " + b1);
		System.out.println("b2 : " + b2);
		
		// 두 객체의 값이 일치하는지 결과 출력
		System.out.println("b1이랑 b2가 같은가?"+b1.equals(b2));
		
		// 첫번째 객체를 복제한 객체 생성함
		Book b3 = (Book)b1.clone();
		
		// 첫번째 객체와 복제 객체의 주소가 같은지 출력
		System.out.println("b1이랑 b3이랑 주소가 같은가? : "+ (b1 == b3));
		// 첫번째 객체와 복제 객체의 내용이 같은지 출력
		System.out.println("b1이랑 b3이랑 내용이 같은가? : "+ (b1.equals(b3)));
	}
	
	private static void testObjectArray() {
		// 상속 실습문제1 : 2번
		Circle[] cr = new Circle[3];
		Rectangle[] rt = new Rectangle[3];
		
		cr[0] = new Circle(10,10,5);
		cr[1] = new Circle(7,7,4);
		cr[2] = new Circle(13,13,7);
		
		rt[0] = new Rectangle(4,5,7,8);
		rt[1] = new Rectangle(5,8,10,13);
		rt[2] = new Rectangle(7,2,3,4);

		for (int i = 0; i < cr.length; i++) {
			System.out.println("=========="+(i+1)+"==========");	
			cr[i].draw();
			rt[i].draw();
		}
	}
	
	private static void testEnCapsulation() {
        //Employee 클래스 사용 테스트
        Employee  emp = new Employee(); //기본생성자 사용해서 객체생성과 초기화처리
        //클래스의 사용 : 클래스타입 레퍼런스변수 = new 생성자(초기값, ....);
        //자료형(Data Type) : 값의 종류를 구분하기 위한 단어
        //기본자료형(Primitive Type), 참조자료형(Reference Type) 두 가지로 구분함
        //기본자료형 : 값을 취급함, 자료형 변수명 = 값;
        //(8가지 : boolean(1), char(2), byte(1), short(2), int(4, 기본), long(8), float(4), double(8, 기본)
        //참조자료형 : 주소를 취급함, 클래스타입 레퍼런스 = 객체의 주소;
        
        System.out.println("emp가 가진 주소 : "+ emp.hashCode());
        System.out.println("emp가 참조하는 객체 안의 값 확인 : "+ emp.toString());
    }
	
	private static void testPointArray() {
		// 상속 실습문제 1 - 3
		// 1. Point 형 객체 배열 선언, 생성 : 5개
		com.practice2.model.entity.Point[] pArray = new com.practice2.model.entity.Point[5];
		
		// 2. 각 index 별로 Circle, Rectangle 객체 생성, 초기화함(임의대로)
		// 부모 레퍼런스에는 후손 객체의 주소를 저장할 수 있다
		pArray[0] = new Circle(100, 100, 50);
		pArray[1] = new Rectangle(200, 200, 50, 50);
		pArray[2] = new Circle(150, 150, 30);
		pArray[3] = new Circle(100, 100, 50);
		pArray[4] = new Rectangle(400, 400, 150, 150);
		
		//	Circle cir = new Rectangle();	// 에러 : 부모 자식관계에서만 대입이 가능하다
		
		// 3. for 문 사용 : draw() 메소드 실행함
		for (int i = 0; i < pArray.length; i++) {
			pArray[i].draw();
		}
		
		System.out.println("=======================================");
		
		// for each 문 사용
		for(com.practice2.model.entity.Point p : pArray) {
			p.draw();		// 컴파일시에는 Point(부모)의 draw() 메소드가 연결됨 : 정적 바인딩
			// 실행시 참조하는 객체 타입에 따라 후손의 오버라이딩된 draw() 로 연결을 바꾸면서 실행함
			// => 동적 바인딩
		}
	}
}
