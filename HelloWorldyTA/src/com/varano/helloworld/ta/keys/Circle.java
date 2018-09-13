//Thomas Varano
//Sep 12, 2018

package com.varano.helloworld.ta.keys;

public class Circle {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle() {
		this(0);
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
