package com.starse.prob5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculatorMain {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dateFormat = "yyyy-MM-dd";

        System.out.print("Enter your birth date (yyyy-mm-dd): ");
        String input = sc.nextLine();
        String datePattern = "\\d{4}-\\d{2}-\\d{2}";
        while (!input.matches(datePattern)) {
            System.out.println("Invalid date format. Please enter the date in the format " + dateFormat);
            input = sc.nextLine();
        }
        
        LocalDate birthDate = LocalDate.parse(input);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        System.out.println("Your age is: " + age.getYears() + " years");
        sc.close();
	}

}
