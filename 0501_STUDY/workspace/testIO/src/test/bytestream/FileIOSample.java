package test.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOSample {
    private Scanner scan = new Scanner(System.in); //의존성 주입 (DI : Dependency Injection)
    
    public void fileSave() { // 1
        //파일에 기록 처리 : 저장 => 파일 출력 스트림 사용
        FileOutputStream fout = null;
        
        //연결할 대상인 파일의 이름을 입력받아서 사용
        System.out.print("저장할 파일명 (파일명.dat) : ");
        String fileName = scan.next();
        
        try {
            fout = new FileOutputStream(fileName);
            //대상 파일이 없으면 자동으로 파일을 만들어서 스트림을 연결함
            //대상 파일이 있으면, 파일 안의 기존 내용을 다 지우고 새로쓰기 상태로 열기함
            System.out.println(fileName + "에 저장할 내용을 입력하세요. --------------------");
            String str = null;
            while((str = scan.nextLine()).equals("exit") != true) {
            	// 사용하는 스트림이 바이트스트림이므로, String => byte[] 로 바꿔야 함
            	fout.write(str.getBytes());
            }
            System.out.println(fileName + " 저장 완료.");
//        } catch (FileNotFoundException e) {
////            e.printStackTrace();
//            System.out.println(e.getMessage());
//            return;
        } catch (IOException e) {	//FileNotFoundException 의 부모클래스이므로 다형성 이용
//			e.printStackTrace();
        	System.out.println(e.getMessage());
        	return;
		}finally {
            //사용이 끝난 스트림은 반드시 반납해야 함
            try {
                fout.close();
            } catch (IOException e) {
            	System.out.println(e.getMessage());
            	return;
            }
        }
    } // fileSave()
    
    public void fileRead() { // 2
    	FileInputStream fin = null;
    	
    	// 읽어 들일 파일을 키보드로 입력받아 사용
    	System.out.print("읽을 파일명 (파일명.dat) : ");
    	String fileName = scan.next();
    	
    	try {
			fin = new FileInputStream(fileName); // 입력 스트림 연결됨
			// 대상 파일이 없으면 예외(에러) 발생함
			
			// 파일 안의 값을 읽어서 콘솔에 출력
			int data;
			while((data = fin.read()) != -1) {
				System.out.print(data);
			}
			System.out.println("\n" + fileName + " 읽기 완료.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		} finally {
			try {
				fin.close();
			} catch (Exception e) {				
				System.out.println(e.getMessage());
			}
		}
    }

	public void fileAppend() { // 3
		//파일에 기록 처리 : 저장 => 파일 출력 스트림 사용
        FileOutputStream fout = null;
        
        //연결할 대상인 파일의 이름을 입력받아서 사용
        System.out.print("추가 저장할 파일명 (파일명.dat) : ");
        String fileName = scan.next();
        
        try {
            fout = new FileOutputStream(fileName, true);
            //대상 파일이 없으면 자동으로 파일을 만들어서 스트림을 연결함
            //대상 파일이 있으면, 파일 안의 기존 내용을 그대로 두고 추가쓰기 상태로 열기함
            System.out.println(fileName + "에 추가할 내용을 입력하세요. --------------------");
            String str = null;
            while((str = scan.nextLine()).equals("exit") != true) {
            	// 사용하는 스트림이 바이트스트림이므로, String => byte[] 로 바꿔야 함
            	fout.write(str.getBytes());
            }
            System.out.println(fileName + " 추가 저장 완료.");
        } catch (IOException e) {	//FileNotFoundException 의 부모클래스이므로 다형성 이용
//			e.printStackTrace();
        	System.out.println(e.getMessage());
        	return;
		}finally {
            //사용이 끝난 스트림은 반드시 반납해야 함
            try {
                fout.close();
            } catch (IOException e) {
            	System.out.println(e.getMessage());
            	return;
            }
        }
	}
	
	// try with resource 문 적용
	public void fileSave2() { // 1
        //파일에 기록 처리 : 저장 => 파일 출력 스트림 사용
		// FileOutputStream fout = null;
        
        //연결할 대상인 파일의 이름을 입력받아서 사용
        System.out.print("저장할 파일명 (파일명.dat) : ");
        String fileName = scan.next();
        
        try (FileOutputStream fout = new FileOutputStream(fileName);) {
        	// try(클래스타입 레퍼런스 = new 생성자(초기값);) => 자동 close 됨 => finally 처리 필요없음
            //대상 파일이 없으면 자동으로 파일을 만들어서 스트림을 연결함
            //대상 파일이 있으면, 파일 안의 기존 내용을 다 지우고 새로쓰기 상태로 열기함
            System.out.println(fileName + "에 저장할 내용을 입력하세요. --------------------");
            String str = null;
            while((str = scan.nextLine()).equals("exit") != true) {
            	// 사용하는 스트림이 바이트스트림이므로, String => byte[] 로 바꿔야 함
            	fout.write(str.getBytes());
            }
            System.out.println(fileName + " 저장 완료.");
//        } catch (FileNotFoundException e) {
////            e.printStackTrace();
//            System.out.println(e.getMessage());
//            return;
        } catch (IOException e) {	//FileNotFoundException 의 부모클래스이므로 다형성 이용
//			e.printStackTrace();
        	System.out.println(e.getMessage());
        	return;
		}
    }

	public void fileRead2() { // 2
    	// 읽어 들일 파일을 키보드로 입력받아 사용
    	System.out.print("읽을 파일명 (파일명.dat) : ");
    	String fileName = scan.next();
    	
    	try (FileInputStream fin = new FileInputStream(fileName);) {
			// 대상 파일이 없으면 예외(에러) 발생함
			// 파일 안의 값을 읽어서 콘솔에 출력
			int data;
			while((data = fin.read()) != -1) {
				System.out.print(data);
			}
			System.out.println("\n" + fileName + " 읽기 완료.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
    }

	public void fileAppend2() { // 3
        //연결할 대상인 파일의 이름을 입력받아서 사용
        System.out.print("추가 저장할 파일명 (파일명.dat) : ");
        String fileName = scan.next();
        
        try (FileOutputStream fout = new FileOutputStream(fileName, true);) {
            //대상 파일이 없으면 자동으로 파일을 만들어서 스트림을 연결함
            //대상 파일이 있으면, 파일 안의 기존 내용을 그대로 두고 추가쓰기 상태로 열기함
            System.out.println(fileName + "에 추가할 내용을 입력하세요. --------------------");
            String str = null;
            while((str = scan.nextLine()).equals("exit") != true) {
            	// 사용하는 스트림이 바이트스트림이므로, String => byte[] 로 바꿔야 함
            	fout.write(str.getBytes());
            }
            System.out.println(fileName + " 추가 저장 완료.");
        } catch (IOException e) {	//FileNotFoundException 의 부모클래스이므로 다형성 이용
        	System.out.println(e.getMessage());
        	return;
		}
	}
}