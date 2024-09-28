package test.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOSample {

	// DI
	private Scanner scan = new Scanner(System.in);
	
	public void fileSave() { // 4
		System.out.print("저장할 파일명 (파일명.txt) : ");
		String fileName = scan.next();
		
		File saveFile = new File(fileName);
		System.out.println("파일 용량 : "+saveFile.length()); // 0
		System.out.println("파일인가? : " + saveFile.isFile()); // true
		System.out.println("디렉토리인가? : " + saveFile.isDirectory()); // false
		
		// 자동 close 처리할 객체 생성 구문을 try() 안에 작성하면 됨
		// try (클래스타입 레퍼런스 = new 생성자(초기값))
		try (FileWriter fw = new FileWriter(saveFile)) {
			// 대상파일 없으면 파일을 자동으로 만듦
			// 대상파일이 있으면, 기존 내용을 지우고 새로쓰기 상태로 열기함
			System.out.println(saveFile.getName() + " 에 저장할 내용을 입력하세요 : ");
			String data;
			while((data = scan.nextLine()).equals("exit") != true) {
				fw.write(data + "\n");
			}
			
			System.out.println(saveFile.getName() + " 저장 완료.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	public void fileRead() { // 5
		
		System.out.print("읽을 파일명 : ");
		String fileName = scan.next();
		
		int data;
		try (FileReader fr = new FileReader(fileName)) {
			// 대상 파일이 없으면 예외 발생함
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (Exception e) { // 다형성 적용
			// FileNotFoundException => Exception 이 받아서 처리할 것임
			// IOException => Exception 이 받아서 처리할 것임
			System.out.println(e.getMessage());
			return;
		}
	}

	public void fileAppend() { // 6
		System.out.println("내용을 추가할 파일명 (.txt) : ");
		String fileName = scan.next();
		
		try (FileWriter fw = new FileWriter(fileName)) {
			// 대상 파일이 없으면, 파일을 새로 만들고 스트림을 연결함
			// 대상 파일이 있으면, 기존 내용을 그대로 두고 추가쓰기 상태로 연결됨
			System.out.println(fileName + " 에 추가할 내용을 입력하세요 : ");
			String data;
			
			while(!(data = scan.nextLine()).equals("exit")) { // (data = scan.nextLine()).equals("exit") != true 와 같음
				fw.write(data + "\n");
			}
			
			System.out.println(fileName + " 추가 저장 완료.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
