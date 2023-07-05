package com.starse.prob2;

public class Student {
	private String name;
	private String currentClass;
	private int age;
	private String gender;

	public Student(String name, String currentClass, int age, String gender) {
		super();
		this.name = name;
		this.currentClass = currentClass;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Name : " + name + " ,\nClass : " + currentClass + " ,\nAge : " + age + " ,\nGender : " + gender+ "\n";
	}

}
