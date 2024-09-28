package poly.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import poly.model.dto.Customer;
import poly.model.dto.Person;
import poly.model.dto.Student;
import poly.model.entity.IShape;
import poly.model.vo.Circle;
import poly.model.vo.Rectangle;
import poly.model.vo.Shape;
import test.abst.AbstractSample;
import test.abst.SubClass;
import test.gui.MyWindow;
import test.poly.PolySample;

public class Menu {
	public static void display() {
		do {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("\n*** 다형성 테스트 ***\n");
			System.out.println("1. 추상(abstract) 클래스 확인");
			System.out.println("2. 상속 연습 : MyWindow");
			System.out.println("3. 다형성 연습 : 메소드 매개변수에 다형성 적용");
			System.out.println("4. 다형성 테스트");
			System.out.println("5. 다형성 실습문제 1 : Shape 상속");
			System.out.println("6. 다형성 실습문제 2 : IShape 상속");
			System.out.println("7. 다형성 실습문제 3 : 객체배열 다형성 사용");
			System.out.println("9. 끝내기");
			System.out.print("번호 입력 >>> ");
			int no = scan.nextInt();
			
			switch(no) {
				case 1: 
					testAbstract();
					break;
				case 2:
					testMyWindow();
					break;
				case 3:
					testPolySample();
					break;
				case 4:
					testPerson();
					break;
				case 5:
					testShape();
					break;
				case 6:
					testIShape();
					break;
				case 7:
					testPolymorphism();
					break;
				case 9:
					System.out.println("\n프로그램을 종료합니다.");
					return; // main() 으로 리턴시킴 => main() 종료됨 
				default: System.out.println("잘못 입력하셨습니다. 확인하고 다시 입력하세요");
			}
		} while(true);		
	}
	private static void testAbstract() { // 1
		// abstract class (미완성 클래스) 사용 테스트
		// abstract 클래스는 객체 생성 못 함, 레퍼런스 변수 선언은 가능함
		AbstractSample samp = null;
		// samp = new AbstractSample();	// 미완성 클래스이므로 객체 생성 못 함, 에러
		Calendar today = null;
		//	today = new Calendar();	// 미완성 클래스이므로 객체 생성 못 함, 에러
		
		// 후손 객체의 주소를 저장하기 위한 용도로 레퍼런스는 선언할 수 있다
		samp = new SubClass();
		today = new GregorianCalendar();
	}
	
	private static void testMyWindow() { // 2
		new MyWindow();
	}
	
	private static void testPolySample() { // 3
		PolySample psamp = new PolySample();
		
		psamp.printObject("메소드 매개변수에 다형성 사용 확인");
		psamp.printObject(new java.util.Date());
		psamp.printObject(1);
		psamp.printObject(2002.0303);
		psamp.printObject(new GregorianCalendar());
	}
	
	private static void testPerson() { // 4
		// 다형성(Polymorphism) : 상속을 통해 사용할 수 있는 기술임
		// 상속관계에 있는 부모클래스는 후손클래스 객체의 주소를 받을 수 있음
		Person p = null;
		
		// 부모타입의 레퍼런스에 후손 객체의 주소 대입 가능함
		p = new Customer("정은지", 23, '여', "ejjung02@beeu.co.kr", "010-7774-8752", "서울시 동작구 대방동", 4528100);
		System.out.println(p);
		
		Customer c = new Customer("오정민", 22, '남', "tsoh03@beeu.co.kr", "010-2695-0533", "서울시 동작구 대방동", 1358000);
		p = c;
		System.out.println(c);
		
		p = new Student("오정민", 22, '남', "tsoh03@beeu.co.kr", "010-2695-0533", 5, "컴퓨터공학과", 4.6);
		System.out.println(p);
		
		Object obj = c;
		System.out.println(obj);
		obj = p;
		System.out.println(obj);
		
		obj = new GregorianCalendar();
		System.out.println(obj);
		
		obj = new String("다형성 확인");
		System.out.println(obj);
		
		// 다형성은 부모가 여러 후손들을 다루는 기술
		// 상속관계가 아닌 클래스 간에는 사용할 수 없음
		// Customer cm = new Student(); // error
	}
	
	private static void testShape() { // 5
		// 상속 다형성 실습문제 1
		Shape s;
		
		s = new Circle(15.5);
		System.out.println("원면적 : " + s.area());
		System.out.println("원둘레 : " + s.perimeter());
		
		s = new Rectangle(34.5, 42.7);
		System.out.println("사각형면적 : " + s.area());
		System.out.println("사각형둘레 : " + s.perimeter());
	}
	
	private static void testIShape() { // 6
		// 상속 다형성 실습문제 1
		IShape s; // 인터페이스(추상클래스)도 레퍼런스 변수 선언은 가능함
		
		s = new poly.model.entity.Circle(15.5);
		System.out.println("원면적 : " + s.area());
		System.out.println("원둘레 : " + s.perimeter());
		
		s = new poly.model.entity.Rectangle(34.5, 42.7);
		System.out.println("사각형면적 : " + s.area());
		System.out.println("사각형둘레 : " + s.perimeter());
	}
	
	private static void testPolymorphism() { // 7
		//다형성 실습문제 3
		IShape[] iarr = new IShape[5]; // 객체배열은 주소배열임. (레퍼런스 배열임)
		// 객체 주소 저장할 레퍼런스변수 5개를 배열로 할당하고, 배열의 시작주소를 iarr 에 기록함
		
		// 5개의 후손 객체를 무작위로 생성함 (Circle, Rectangle, Triangle)
		iarr[0] = new poly.model.entity.Circle(5.8);
		iarr[1] = new poly.model.entity.Rectangle(6.7, 11.4);
		iarr[2] = new poly.model.entity.Triangle(14.2, 18.5);
		iarr[3] = new poly.model.entity.Circle(10.9);
		iarr[4] = new poly.model.entity.Triangle(22.9, 23.4);
		
		// for loop 문으로 각 객체의 면적과 둘레를 출력 처리
		// 단, Triangle 객체는 빗변길이도 같이 출력처리함
		for (int i = 0; i < iarr.length; i++) {
			// instanceof 연산자 : 레퍼런스가 참조하는 객체의 클래스타입을 묻는 연산자
			// if(레퍼런스 instanceof 클래스타입)
			if(iarr[i] instanceof poly.model.entity.Circle) {
				System.out.println("원면적 : " + iarr[i].area());
				System.out.println("원둘레 : " + iarr[i].perimeter());				
			}
			else if(iarr[i] instanceof poly.model.entity.Rectangle) {
				System.out.println("사각형면적 : " + iarr[i].area());
				System.out.println("사각형둘레 : " + iarr[i].perimeter());								
			}
			else if(iarr[i] instanceof poly.model.entity.Triangle) {
				// 후손 멤버는 부모레퍼런스로 참조할 수 없음 => 후손타입으로 형변환 필요함
				System.out.println("삼각형면적 : " + iarr[i].area());
				System.out.println("삼각형둘레 : " + iarr[i].perimeter());
				System.out.println("삼각형빗변 : " + ((poly.model.entity.Triangle) iarr[i]).getHypotenuse());
			}
		}
	}
} // Menu class
