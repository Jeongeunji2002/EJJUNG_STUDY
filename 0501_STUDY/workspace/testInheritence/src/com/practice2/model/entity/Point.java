package com.practice2.model.entity;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int setY() {
		return this.y;
	}
	
	public void draw() {
		System.out.println("x="+this.x+", y="+this.y);
	}
}
