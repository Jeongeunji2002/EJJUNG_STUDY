package com.practice1.model.vo;

public class Book {
	private String title;
	private String author;
	private int price;

	// Constructor
	// 생성자는 오버로딩(Overloading) 가능 => 한 클래스 안에서 이름이 같은 함수 여러 개 작성 (중복 작성)
	// 오버로딩 작성 규칙 : 매개변수가 반드시 달라야 함 (갯수, 자료형, 나열순서)
	// 접근제한자, 리턴타입은 오버로딩 판단 대상이 아님 => 함수명과 매개변수로만 중복을 판단함 
	public Book() {}		// 매개변수 없는 생성자 : 기본생성자
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return "title="+this.title+", author="+this.author+", price="+this.price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Book bobj = (Book)obj;
		return (this.title.equals(bobj.title)) && (this.author.equals(bobj.author)) && (this.price == bobj.price);
	}
	
	@Override
	public Object clone() {
		return new Book(this.title, this.author, this.price);
	}
}
