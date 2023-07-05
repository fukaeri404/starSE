package com.starse.prob2;

import java.util.ArrayList;

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		Student student1 = new Student("Ma Sabal", "Geology Class", 23, "Female");
		Student student2 = new Student("Mg Aung", "Mathematics Class", 20, "Male");
		Student student3 = new Student("Ma Phyu", "Language Class", 19, "Female");
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
	}

}