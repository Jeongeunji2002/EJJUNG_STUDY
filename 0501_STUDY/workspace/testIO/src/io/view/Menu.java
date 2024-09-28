package io.view;

import java.util.Scanner;

import test.bytestream.FileIOSample;
import test.objectio.MemberManager;

public class Menu {
	private static FileIOSample fsamp = new FileIOSample();
	private static test.charstream.FileIOSample csamp = new test.charstream.FileIOSample();
	private static MemberManager manager=new MemberManager();
	
	public static void display() {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("\n *** 입출력 관련 클래스 사용 테스트 *** \n");
			System.out.println("1. 파일 출력 : FileOutputStream - 새로 쓰기 모드");
			System.out.println("2. 파일 읽기 : FileInputStream");
			System.out.println("3. 파일 읽기 : FileOutputStream - 추가 쓰기 모드");
			System.out.println("4. 파일 출력 : FileWirter - 새로 쓰기 모드");
			System.out.println("5. 파일 읽기 : FileReader");
			System.out.println("6. 파일 읽기 : FileWirter - 추가 쓰기 모드");
			System.out.println("7. Member 객체 파일에 저장");
			System.out.println("8. 파일로부터 Member 객체 읽어와서 출력 확인");
			System.out.println("9. 끝내기");
			
			System.out.print("번호 선택 >>> ");
			int su = scan.nextInt();
			
			switch(su) {
				case 1: fsamp.fileSave2(); break;
				case 2: fsamp.fileRead2(); break;
				case 3: fsamp.fileAppend2(); break;
				case 4: csamp.fileSave(); break;
				case 5: csamp.fileRead(); break;
				case 6: csamp.fileAppend(); break;
				case 7: csamp.fileAppend(); break;
				case 8: csamp.fileAppend(); break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 번호입니다. 확인하고 다시 입력하세요.");
			}
		}while(true);
	}
}
