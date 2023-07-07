package com.starse.prob12;

public final class StudentManagementSystem {
	public static void main(String[] args) {
		StudentManagmentService studentManagmentService = StudentManagmentService.getInstance();
		studentManagmentService.initializeData();
	}
}
