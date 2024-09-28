package test.generics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericeSample {
	public void test1() {
		// 컬랙션 클래스들은 여러 종류의 클래스 객체들을 저장할 수 있음
		List list = new ArrayList();

		list.add(new String("java"));
		list.add(new Book("자바 완성,", "홍길동"));
		list.add(new Date());

		System.out.println(list);

		// 저장된 객체를 하나씩 꺼내서 사용하려고 할 때, 기본적으로 Object 타입으로 추출됨
		// get(index) : Object 반환됨
		for (Object obj : list) {
			// Object 타입의 레퍼런스로는 Object 클래스가 가진 메소드나 필드만 다룰 수 있음
			// toString(), equals(), clone(), hashCode() 메소드만 사용할 수 있다.
			// 후손클래스들이 오버라이딩한 경우에는 실행시 오버라이딩된 후손쪽 메소드로 연결이 바뀌면서 실행됨
			System.out.println(obj/* .toString() */);

			// 만약, 각 후손클래스가 가진 멤버를 사용하려면 Object 레퍼런스로는 다룰 수 없음
			// obj.toUpperCase(); //String 클래스의 대문자로 변환 메소드임 =>에러발생
			// 해결 방법은 Object 레퍼런스를 각 후손 클래스 타입으로 형변환해야 함
			// 다운 캐스팅시에 래퍼런스가 참조하는 인스턴스의 타입을 확인하고 형변환 할 필요가 있음
			// =>래퍼런스 instanceof 클래스타입
			if (obj instanceof String) {
				String s = (String) obj;
				System.out.println(s + " => " + s.toUpperCase());
				// 코드축약
				System.out.println(((String) obj).toUpperCase());

			}
			if (obj instanceof Book) {
				System.out.println(((Book) obj).getTitle() + ", " + ((Book) obj).getAuthor());
			}
			if (obj instanceof Date) {
				System.out.println(new SimpleDateFormat("yyyy'년' MM'월' dd'일' E").format((Date) obj));
			}
		}
	}// test1()

	public void test2() {
		// 제네릭스(Generics) 기능 :
		// 클래스 사용 시 다룰 객체에 대한 타입을 정하면서 이용하는 기능
		// 클래스명<영문자> 또는 인터페이스<영문자> 표시된 클래스들이 제네릭스 기능을 사용할 수 있다는 표시
		// 클래스 사용시 한 가지 타입의 클래스 객체만 취급하겠다는 용도로 사용함
		List<String> list = new ArrayList<String>(); // String 객체만 저장하는 리스트로 선언함
		// String이 아닌 객체는 저장할 수 없음, 에러남

		// 제네릭스가 적용된 래퍼런스가 메소드로 전달되면, 받아주는 매개변수도 같은 제내릭 타입 지정을 해야 함
		listInitialization(list);
		// 제네릭스 사용 장점 : 객체 추출시 다운 캐스팅(형변환) 필요없음
		for (String s : list) {
			System.out.println(s);
		}
	}

	private void listInitialization(List<String> list) {
		// 매개변수에도 제네릭 타입 계속 표기해 줘야 함
		list.add("apple");
		list.add(new String("oracle"));
		// list.add(new Date()); //선언된 제네릭 타입이 아닌 객체는 저장할 수 없음
		list.add("grape");
	}

	public void test3() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		initList(bookList);
		printList(bookList);
	}

	private void initList(ArrayList<Book> list) {
		list.add(new Book("java 정복", "김철수"));
		list.add(new Book("oracle 완성", "이영희"));
		list.add(new Book("jdbc 로직", "황지니"));
//		list.add(new String("test")); //error
	}

	private void printList(List<Book> list) {
		// 클래스 타입 확인(instanceof) 필요없음
		// 형변환 필요 없음 => 제네릭스 사용 목적
		for (Book b : list) {
			System.out.println(b);
		}
	}

	public void testSet() {
		Set<Book> books = new HashSet<Book>();

		initSet(books);
		printSet(books);
	}

	private void initSet(Set<Book> set) {
		set.add(new Book("java 정복", "김철수"));
		set.add(new Book("oracle 완성", "이영희"));
		set.add(new Book("jdbc 로직", "황지니"));
	}

	private void printSet(Set<Book> set) {
		Iterator<Book> iter = set.iterator();
		while (iter.hasNext()) {
			Book book = iter.next(); // 형변환 필요없음
			System.out.println(book);

		}
	}

	public void testMap() {
		Map<Integer, Book> books = new HashMap<Integer, Book>();
		// Map<K, V> : K(Key 의 클래스타입), V(value 의 클래스타입)

		initMap(books);
		printMap(books);
	}

	private void initMap(Map<Integer, Book> map) {
		map.put(3, new Book("자바 컬레션", "홍길순"));
		map.put(7, new Book("JDBC MVC", "이영광"));
		map.put(12, new Book("spring legacy", "최쉬운"));
		// map.put("25", new Book()); //에러
		// map.put(25, new Date()); //에러
	}

	private void printMap(Map<Integer, Book>map) {
		//keySet() : 키=값 출력
		Iterator<Integer> keyIter = map.keySet().iterator();
		while (keyIter.hasNext()) {
			Integer key = (Integer) keyIter.next();
			System.out.println(key +"=" +map.get(key));
		}
		//entrySet() : 키=값 출력
		Iterator<Map.Entry<Integer, Book>> entries=map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, Book> entry = entries.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}

class Book {
	private String title;
	private String author;

	public Book() {
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}

}