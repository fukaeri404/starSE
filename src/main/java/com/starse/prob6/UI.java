package com.starse.prob6;

import java.util.ArrayList;

final public class UI {

	private static UI ui;
	private Expenses particularExpense;

	private UI() {
	}

	public static UI getInstance() {
		if (ui == null)
			ui = new UI();
		return ui;
	}

	void displayAmount(double amount) {
		System.out.printf("Your remaining amount : %.2f yen%n", amount);
	}

	void displayExpenses(ArrayList<Expenses> expensesList) {
		if (expensesList != null && !expensesList.isEmpty()) {
			System.out.printf("Expenses%n========%n");
			for (Expenses expenses : expensesList) {
				System.out.printf("%d. %s : %.2f yen %n", expenses.getId(), expenses.getName(), expenses.getExpense());
			}
		}

//		System.out.printf(
//				"Expenses%n"
//				+ "========%n"
//				+ "1. House Rent Expense : %.2f yen%n"
//				+ "2. Phone Bill Expense : %.2f yen%n"
//				+ "3. Shopping Bill Expense : %.2f yen%n"
//				+ "4. Water Bill Expense : %.2f yen%n"
//				+ "5. Gas Bill Expense : %.2f yen%n"
//				+ "Choose number 1~5 to edit specific expenses : %n", houseRent.getExpense(),phoneBill.getExpense(),  shoppingBill.getExpense(), waterBil.getExpense(), gasBill.getExpense());
	}

	void displayParticularExpense(int id) {
		for (Expenses expense : Expenses.EXPENSES_LIST) {
			if (id == expense.getId()) {
				setParticularExpense(expense);
				System.out.printf("Please input new expense for %s : ", expense.getName());
				break;
			}
		}
	}

	public Expenses getParticularExpense() {
		return particularExpense;
	}

	public void setParticularExpense(Expenses particularExpense) {
		this.particularExpense = particularExpense;
	}
}
