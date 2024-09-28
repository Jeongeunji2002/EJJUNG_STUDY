package com.practice2.model.entity;

public class Rectangle extends Point {
	
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		int rectanArea = width*height;
		int rectanCircum = 2 * (width+height);
		
		super.draw();
		System.out.println("사각형 면적 : " + rectanArea);
		System.out.println("사각형 둘레 : " + rectanCircum);
	}
}
