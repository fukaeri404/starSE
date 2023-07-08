package com.starse.prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseCalculatorService {
	private static ExpenseCalculatorService expenseCalculatorService;
	private final Map<String, Double> expensesList = new HashMap<>();
	private final ArrayList<String> expensesType = new ArrayList<>(Arrays.asList("House-Rent", "Phone-Bill",
			"Shopping-Bill", "Electric-Bill", "Water-supply Bill", "Gas-Bill"));
	private double remaining = 200000;

	private ExpenseCalculatorService() {

	}

	void initializeData() {
		for (String type : expensesType) {
			expensesList.put(type, 0.0);
		}
	}

	void inputExpenses(Scanner sc) {
		for (String type : expensesType) {
			double userinput;
			while (true) {
				System.out.print("Enter the amount for " + type + ":");
				while (!sc.hasNextDouble()) {
					sc.next();
					System.out.println("Invalid input. Please enter amount in number for " + type + " :");
				}
				userinput = sc.nextDouble();
				double temp = remaining - userinput;
				if (temp > 0) {
					remaining -= userinput;
					for (Map.Entry<String, Double> entry : expensesList.entrySet()) {
						if (type.equalsIgnoreCase(entry.getKey())) {
							entry.setValue(userinput);
							break;
						}
					}
					System.out.println("->->->Your remaining amount is : " + remaining);
					break;
				} else
					System.out.println("XXXSorry!Please re-enter amount that is lower than your remaining amount "+remaining);
			}
		}
	}

	public static ExpenseCalculatorService getInstance() {
		if (expenseCalculatorService == null)
			expenseCalculatorService = new ExpenseCalculatorService();
		return expenseCalculatorService;
	}
}
