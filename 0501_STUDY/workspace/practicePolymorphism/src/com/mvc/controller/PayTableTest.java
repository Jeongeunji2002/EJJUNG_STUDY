package com.mvc.controller;

import com.mvc.model.Salary;

public class PayTableTest {
	public static void main(String[] args) {
		Salary[] pt = new Salary[3];
		pt[0] = new PayTable("소서노",750000,2,3);
		pt[1] = new PayTable("고주몽",800000,1,4);
		pt[2] = new PayTable("모팔모",650000,6,2);

		
		System.out.println("                                        **** 급여명세서 ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("이름\t기본급\t가족수\t가족수당\t시간외근무\t시간외수당\t세금\t인센티브(%)\t성과금\t실수령액");
		for (int i = 0; i < pt.length; i++) {
			((Calculate) pt[i]).calc();
			((Output) pt[i]).out();
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("인원수: "+Salary.getCount()+"명");
		
		Salary.setIncentive(0.7f);
		
		System.out.println("                                        **** 급여명세서 ****");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("이름\t기본급\t가족수\t가족수당\t시간외근무\t시간외수당\t세금\t인센티브(%)\t성과금\t실수령액");
		for (int i = 0; i < pt.length; i++) {
			((Calculate) pt[i]).calc();
			((Output) pt[i]).out();
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("인원수: "+Salary.getCount()+"명");
	}
}
