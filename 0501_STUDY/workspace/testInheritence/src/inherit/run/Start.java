package inherit.run;
import inherit.sample.Point;

//실행 클래스
public class Start {

	public static void main(String[] args) {
		// 애플리케이션의 실행을 담당하는 메소드임 : start 스위치임
		
		// static 필드 확인 : main 시작시 자동 정적메모리에 할당된 것 확인
//		System.out.println(Menu.value);
//		System.out.println(Menu.value2);
		
		Menu.display();
		System.out.println("main 을 종료합니다.");
	}

}
