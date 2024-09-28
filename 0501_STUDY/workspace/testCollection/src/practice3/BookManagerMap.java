package practice3;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookManagerMap {
	//Field
	private HashMap booksMap; //도서번호를 키로 사용함
	
	public BookManagerMap() {
		booksMap = new HashMap();
	}
	
	public BookManagerMap(Map map) {
		booksMap= new HashMap(map);
	}
	//Method
//		+putBook(book:Book) : void //맵에 객체 추가, 도서번호를 키로 사용함
	public void putBook(Book book) {
		booksMap.put(book.getbNo(), book);
	}
//		+removeBook(key:String) : void //맵에서 객체 제거
	public void removeBook(String key) {
		booksMap.remove(key);
	}
//		+searchBook(String bTitle) : String : entrySet() 사용
//			//도서명이 일치하는 객체의 도서번호를 리턴함
	//도서명이 객체가 맵에 없으면, null 리턴함
	public String searchBook(String bTitle) {
		String key = null;
		Iterator booksLter= booksMap.entrySet().iterator();
		while(booksIter.hasNext()) {
			Map.Entry entry = (Map.Entry)booksIter.next();
			key = (String)entry.getKey();
			Book
		}
	}
//		+displayAll():void		//맵정보 모두 출력 :keySet()사용
	
	public void displayAll() {
		Iterator bookster = booksMap.keySet().iterator();
		while(booksIter.hasNext()) {
			System.out.println(booksMap.get(booksIter.next()));
		}
//		+sortdeBookMap():Book[]
//				해당 도서순으로 오름차순 정렬해서 객체배열 리턴함
		public Book[] sortedBookMap() {
			//방법1
			List bookList = new ArrayList(booksMap.values());
			bookList.sort(new AscBookTitle());
			
			Book[] bar = new Book[bookList.size()];
			bookList.toArray(bar);
			
			return bar;
			
			//방법 2
			TreeMap tmap = new TreeMap(new AscBookTitle());
			tmap.putALl(book)
		}
	}
		
}
