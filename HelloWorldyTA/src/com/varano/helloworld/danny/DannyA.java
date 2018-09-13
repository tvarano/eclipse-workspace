//Thomas Varano
//Aug 6, 2018

package com.varano.helloworld.danny;

import java.awt.Point;

public class DannyA {
	public static final String NAME_OF_THING = "danny";
	private int ageOfThing;
	
	
	
	/*
	 * abcdefg
	 * 
	 * 1,4
	 */
	
//	public void sub(String str) {
//		str.substring(start (inclusive), end (exclusive))
//	}
	
	public static boolean equa() {
		Point a = new Point(0, 1);
		System.out.println(a.hashCode());
		Point b = new Point(0, 1);
		System.out.println(b.hashCode());
		return a == b;
	}

	
	public static void main(String[] args) {
//		System.out.println(equa());
		String a = "hi";
		String b = "hi there".substring(0, 2);
	}
}
