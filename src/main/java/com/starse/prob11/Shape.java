package com.starse.prob11;

public abstract sealed class Shape permits Circle, Rectangle {
	private String color;

	abstract double getArea();

	abstract double getPeremeter();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
