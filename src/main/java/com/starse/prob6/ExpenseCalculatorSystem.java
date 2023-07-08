package com.starse.prob6;

import java.util.Scanner;

public class ExpenseCalculatorSystem {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ExpenseCalculatorService service = ExpenseCalculatorService.getInstance();
		service.initializeData();
		service.inputExpenses(sc);
	}

}
