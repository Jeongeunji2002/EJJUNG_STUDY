package practice3;

import java.util.Scanner;

public class TestBookManagerMap {//Field
		//의존성 주입(DI : Dependency Injection)=> 의존관계 만듦
		private static SetSample ssamp = new SetSample();
		
		public static void display() {
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.println("\n***컬렉션 사용 테스트***\n");
				
				System.out.println("1. HashSet 사용 테스트");
				System.out.println("2. LinkedHashSet 사용 테스트");
				System.out.println("3. Treeset 사용 테스트");
				System.out.println("4. Treeset 실습 : 로또 번호 생성");
				System.out.println("5. ArrayList 사용 테스트");
				System.out.println("6.끝내기");
				
				System.out.print("번호 선택 : ");
				
				int no = sc.nextInt();
				
				switch (no) {
				case 1 : bManager.putBook(intBook()); break;
				case 2 : bManager.testLinkedHashSet(); break;
				case 3 : bManager.testTreeSet(); break;
				case 4 : bManager.lottoDisplay(); break;
				case 5 : bManager.testArrayList(); break;
				case 6 : System.out.println("프로그램 종료");
//				 		System.exit(0);
				 		return;
				default:System.out.println("잘못 입력. 확인하고 다시 입력");
				}
			} while (no !=6);
		}

	}


