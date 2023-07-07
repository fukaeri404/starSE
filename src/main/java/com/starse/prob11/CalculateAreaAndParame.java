package com.starse.prob11;

import java.util.Scanner;

public class CalculateAreaAndParame {
	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Shape circ = Circle.getInstance();
		Shape rect = Rectangle.getInstance();
		System.out.println("Welcome to Area and Peremeter Calculator");
		System.out.print("Enter the radius of the circle : ");
		if(circ instanceof Circle)
			((Circle)circ).setRadius(Validation.validate(sc));
		System.out.print("Enter the width of the rectangle : ");
		double width = Validation.validate(sc);
		System.out.print("Enter the height of the rectangle : ");
		double height = Validation.validate(sc);
		if(rect instanceof Rectangle) {
			((Rectangle)rect).setWidth(width);
			((Rectangle)rect).setHeight(height);
		}
		
		System.out.println("Area of circle : " + circ.getArea());
		System.out.println("Peremeter of circle :" + circ.getPeremeter());
		System.out.println("Area of rectangle :" + rect.getArea());
		System.out.println("Peremeter of rectangle :" + rect.getPeremeter());
		sc.close();
	}
}
