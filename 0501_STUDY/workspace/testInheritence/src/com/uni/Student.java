package com.uni;

public class Student extends Human {
	
	private String number;
	private String major;
	
	public Student() {
		
	}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public String printInformation() {
		return super.printInformation() + "\t" + this.number + "\t" + this.major; 
	}
}
