package Collection.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetSample {
	
	//@SuppressWarnings("removal")
	public void testHashSet() {
		HashSet hset = new HashSet(); //저장공간 : 16, 확장비율 0.75
		//Set hset2 = new HashSet();
		//Collection hset3 = new HashSet(); 
		
		//객체(instance)만 저장할 수 있다
		hset.add(new String("java"));
		hset.add(Integer.valueOf(120));
		hset.add(Double.valueOf(33.58));
		hset.add("oracle"); //Auto Boxing : data => object
		hset.add(345);//Auto Boxing : data => object
		hset.add(45.6);//Auto Boxing : data => object
		hset.add(new User("Cadencia","Pwd3037","정은지"));
		
		//저장 순서 유지 안됨
		System.out.println(hset);	//hset.toString() 작동됨.
		System.out.println("저장된 객체수 : "+hset.size());
		
		//Set은 중복 저장 허용 안 함 (중복 검사 기능 내장되어 있음)
		hset.add("oracle");	//중복 저장시 무시됨
		hset.add(345);
		
		System.out.println(hset);	//hset.toString() 작동됨.
		System.out.println("저장된 객체수 : "+hset.size());
		
		//Set 은 저장순서가 없으므로, 하나씩 꺼내는 기능이 없음
		//제거
		hset.remove("oracle");
		System.out.println(hset);	//hset.toString() 작동됨.
		System.out.println("저장된 객체수 : "+hset.size());
		
		//Set은 저장순서가 없으므로, 하나씩 저장되니 객체를 꺼내는 기능이 없음
		//방법 1 : toArray()로 Object[]로 바꾸어서 하나씩 다루거나
		//방법 2 : Iterator() 로 지정된 객체에 대한 목록을 만들어서, 목록으로 하나씩 꺼내도록 처리함
		
		System.out.println("\n toArrary()로 연속 처리 ------------------------------------");
		//set => Object to Array()
		Object[] array = hset.toArray();
		for(Object obj : array) {
			System.out.println(obj);
			
			System.out.println("\n Interator로 연속 처리");
			Iterator iter = hset.iterator();
			while (iter.hasNext()) {
				Object ref=iter.next();
				System.out.println(ref);
				
			}
			hset.clear();
			System.out.println(hset.isEmpty());
			System.out.println(hset.size());
		}
		
		
		
	}//testHashSet()
	
	public void testLinkedHashSet() {
		LinkedHashSet linkSet = new LinkedHashSet();
		linkSet.add("apple");
		linkSet.add(123);
		linkSet.add(3.45);
		linkSet.add(123);
		linkSet.add(new User("user002", "pwd002","이순신"));
		
		System.out.println(linkSet);
		System.out.println(linkSet.size());
		System.out.println("\n toArray() ---------------------------------------------------------");
		Object[] array = linkSet.toArray();
		for(Object obj : array) {
			System.out.println(obj);
		}
		System.out.println("\n iterator() ---------------------------------------------------------");
		Iterator objliter = linkSet.iterator();
		while(objliter.hasNext()) {
			Object obj = objliter.next();
			System.out.println(obj);
		}
	}//testLinkedHashSet
	
	public void testTreeSet() {
		//TreeSet: 자동 오름차순정렬 기능이 내장된 Set 후손 클래스임
		//주의사항 : 같은 종류의 클래스 객체들만 저장해야 함
		TreeSet tset = new TreeSet();
		
		tset.add("banana");
		tset.add("apple");
		tset.add("grape");
		tset.add("apple"); //중복저장 안됨, 무시됨
//		tset.add(new User("user03", "pass03", "황지니"));
		System.out.println(tset);
		//내림차순정렬된 목록 리턴 descendingIterator() : Iterator
		System.out.println("descendingIterator() ----------------------------------");
		Iterator descIter = tset.descendingIterator();
		while(descIter.hasNext()) {
			System.out.println(descIter.next());
		}
	}//testTreeSet
	//Set 실습문제
	public void lottoDisplay() {
		//1. 1~ 45 사이의 정수를 중복되지 않게, 6개 발생시켜
		//2. 자동 오름차순정렬되게 처리하는 Set 계열에 보관하고
		TreeSet dobak = new TreeSet();
		Random ran = new Random();
		
		while(true) { //반복 횟수가 정해지지 않은 경우 사용
			dobak.add(ran.nextInt(45)+1); //ran.nextInt(45) 0~44 사이의 정수 발생
			if(dobak.size()==6) {//반복 종료 조건
				break; //반복 종료
			}
		}
		//3.Int[]로 바꾸어 출력
		int[] lotto = new int[dobak.size()]; //배열 공간 할당 : 6개
		Object[] array = dobak.toArray();
		for (int i = 0; i < array.length; i++) {
			lotto[i] = (Integer)array[i]; //Object =>Integer 로 형변환 int 로 자동 UnBoxing
			//UnBoxing : 객체 = > 값으로 변환되는 것
			System.out.println(lotto[i] + " "); //출력확인
		}
		System.out.println();
	}
	
}//set Sample

//한 자바 파일 안에서 클래스 여러 개 작성할 수도 있음
//파일명.java로 지정되는 클래스만 public 붙일 수 있음
//파일명으로 사용되는 클래스를 제외한 다른 클래스에는 public 사용 못함 => default class
//default : package private (해당 패키지 내에 있는 클래스끼리만 사용 가능함, 패키지 밖 사용 불가능)

class User{
	private String useId;
	private String userPwd;
	private String userName;
	
	public User(String useId, String userPwd, String userName) {
		this.useId = useId;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}