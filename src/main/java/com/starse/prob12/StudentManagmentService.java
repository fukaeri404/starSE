package com.starse.prob12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagmentService {
	final static Scanner sc = new Scanner(System.in);
	private static StudentManagmentService studentManagmentService;
	final static ArrayList<Student> studentList = new ArrayList<>();
	final String filename = "src/main/java/com/starse/prob12/studentAttendance.txt";

	private StudentManagmentService() {

	}

	void initializeData() {
//		if (emptyFile()) {
			Student student1 = new Student(1, "Taro  ", '"');
			Student student2 = new Student(2, "Hanako", '"');
			Student student3 = new Student(3, "Sato  ", '"');
			Student student4 = new Student(4, "Nanase", '"');
			studentList.add(student1);
			studentList.add(student2);
			studentList.add(student3);
			studentList.add(student4);
			writeTo();
			initialDisplay();
//		}
		
	}

	void displayAllStudent() {
		readFrom();
		initialDisplay();
	}

	void initialDisplay() {
		System.out.println("Welcome to Student Attendance Management System. Please choose an option : ");
		System.out.println("1. View all student's attendance");
		System.out.println("2. Mark attendance");
		System.out.println("3. Exit");
		System.out.println("Enter your choice : ");
		mapp(Validation.validate(sc, 1, 3, "initial"));
	}

	void markAttendance() {
		System.out.println("Please enter Student ID : ");
		int studentId = Validation.validate(sc, 1, 4, "student");
		boolean wrote = false;
		do {
			System.out.println("Enter the attendance status (p or a) : ");
			char userinput = sc.next().charAt(0);
			if (userinput == 'p' || userinput == 'a') {
				studentList.get(studentId - 1).setAttendanceStatus(userinput);
				writeTo();
				wrote = true;
			}
		} while (!wrote);
		System.out.println("Attendance data has been written to file.");
		initialDisplay();
	}

	void exit() {
		System.out.print("Exiting Student Attendance Management System. GoodBye!");
		System.exit(0);
	}

	void showErrorMessage() {

	}

	void mapp(int userinput) {
		switch (userinput) {
		case 1 -> displayAllStudent();
		case 2 -> markAttendance();
		case 3 -> exit();
		default -> showErrorMessage();
		}
	}

	void writeTo() {
		try {
			FileWriter writer = new FileWriter(filename);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write("Name       Attendance Status");
			bufferedWriter.newLine();
			for (Student student : studentList) {
				bufferedWriter.write(student.getStudentName() + "       " + student.getAttendanceStatus());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void readFrom() {
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		}
	}

//	boolean emptyFile() {
//		boolean isBlank = false;
//		try {
//			FileReader reader = new FileReader(filename);
//			BufferedReader bufferedReader = new BufferedReader(reader);
//			String line = bufferedReader.readLine();
//			if (line == null || line.trim().isEmpty())
//				isBlank = true;
//			bufferedReader.close();
//		} catch (IOException e) {
//			System.out.println("An error occurred while reading the file.");
//			e.printStackTrace();
//		}
//		return isBlank;
//	}

	public static StudentManagmentService getInstance() {
		if (studentManagmentService == null)
			studentManagmentService = new StudentManagmentService();
		return studentManagmentService;
	}
}
