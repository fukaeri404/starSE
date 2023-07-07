package com.starse.prob11;

public final class Circle extends Shape {

	private static Circle circle;

	double radius;

	@Override
	double getArea() {
		return 3.14 * this.radius * this.radius;
	}

	@Override
	double getPeremeter() {
		return 2 * 3.14 * this.radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static Circle getInstance() {
		if (circle == null)
			circle = new Circle();
		return circle;
	}

}
