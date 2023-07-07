package com.starse.prob11;

public final class Rectangle extends Shape {

	double width;
	double height;

	private static Rectangle rectangle;

	@Override
	double getArea() {
		return this.width * this.height;
	}

	@Override
	double getPeremeter() {
		return 2*(this.width + this.height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public static Rectangle getInstance() {
		if (rectangle == null)
			rectangle = new Rectangle();
		return rectangle;
	}

}
