package com.practice2.model.entity;
import java.lang.Math;

public class Circle extends Point {
	private int radius;
	
	public Circle() {
		
	}
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public void draw() {
		double circleArea = Math.PI * radius * radius;
		double circleCircum = 2 * Math.PI * radius;
		
		circleArea = Math.round(circleArea * 10)/10.0;
		circleCircum = Math.round(circleCircum * 10)/10.0;
		
		super.draw();
		System.out.println("원 면적 : " + circleArea);
		System.out.println("원 둘레 : " + circleCircum);
	}
}
