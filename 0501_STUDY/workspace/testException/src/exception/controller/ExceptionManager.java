package exception.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import exception.silsub1.CharCheckException;
import exception.silsub1.CharacterProcess;
import make.exception.MyException;
import make.exception.NotDivideZeroException;

//예외처리 테스트를 위한 기능 제공용 클래스
public class ExceptionManager {

	// Method
	public void testException1() {
		// 자바가 제공하는 클래스의 생성자 또는 메소드 사용시, 반드시 예외처리해야 되는 경우가 있음
		// 생성자나 메소드 뒤쪽에 throws XXXXException 이 표기되어 있는 경우
		try {
			FileReader fr = new FileReader("sample1.txt"); // 반드시 예외처리해야 하는 구문
			System.out.println("작동되는 지 확인"); // 위의 구문에서 예외가 발생하면, 이 구문은 실행 안 됨
		} catch (FileNotFoundException e) {
			// 해당 에러가 발생했을 때 처리 구문을 작성함
//			e.printStackTrace();
			System.out.println("대상 파일이 존재하지 않습니다");
			return; // Menu로 돌려보냄
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생해도 작동됨, 예외가 발생하지 않아도 작동됨
			// 반드시 실행새켜야 되는 구문을 작성함
			System.out.println("finally 작동중");
		}
	}

	public void testException2() throws FileNotFoundException {
		methodA();
	}

	public void methodA() throws FileNotFoundException {
		methodB();

	}

	public void methodB() throws FileNotFoundException {
		methodC(); // 메소드 사용 위치로 예외가 넘어옴
		// 예외 처리 직접하지 않고 넘김 (throws)
	}

	public void methodC() throws FileNotFoundException {
		new FileReader("sample.txt");
		// 예외를 직접 해결 처리하지 않고 처리할 예외를 넘겨버림
	}

	// 사용자 정의 예외 클래스 사용 테스트
	public void testCalculator() {
		Calculator calc = new Calculator();

		try {
			System.out.println("더하기 결과 : " + calc.sum(23, 55));
			System.out.println("빼기 결과 : " + calc.sub(23, 55));
			System.out.println("곱하기 결과 : " + calc.mul(23, 55));
			System.out.println("나누기 결과 : " + calc.div(23, 55));

//			System.out.println("나누기 결과 : "+ calc.div(23, 0));
//			System.out.println("더하기 결과 : "+ calc.sum(23, -55));
		} catch (MyException | NotDivideZeroException e) {
			// 상속관계에서 형제 관게인 예외 클래스들은 하나의 catch로 다룰 수 있음
			System.out.println(e.getMessage());
			e.printStackTrace();
		} /*
			 * catch (NotDivideZeroException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

	}

	// 예외 실습 1 : 문제1
	public void testSilsub1() {
		// 키보드로 문자열 입력받아서 영문자가 몇개인지 카운트해서 리턴
		// 단, 공백문자가 있으면 CharCheck
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("문자열 입력 : ");
			String s=sc.nextLine();
			CharacterProcess cp = new CharacterProcess();
			cp.countAlpha(s);
			System.out.println("알파벳 개수 : "+cp.countAlpha(s));
			
		}catch(CharCheckException e) {
			System.out.println(e.getMessage());
			System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다.");
		}
	}

	// 예외 실습 2 : 문제2
	public void testSilsub2() {
	}
	// 키보드로 문자열 입력받아서 영문자가 몇개인지 카운트해서 리턴
	// 단, 공백무낮가 있으면 CharCheck
}
