package com.starse.prob6;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseCalculatorMain {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		UI ui = UI.getInstance();
		double amount = 200000.00;
		final Expenses houseRentExpense = new HouseRentExpense(1, "House Rent expense", 0.0);
		final Expenses phoneBillExpense = new PhoneBillExpense(2, "Phone Bill Expense", 0.0);
		final Expenses shoppingBillExpense = new ShoppingExpense(3, "Shopping Bill Expense", 0.0);
		final Expenses waterBillExpense = new WaterSupplyExpense(4, "Water Bill Expense", 0.0);
		final Expenses gasBillExpense = new GasBillExpense(5, "Gas Bill Expense", 0.0);
		ArrayList<Expenses> expensesList = Expenses.EXPENSES_LIST;
		expensesList.add(houseRentExpense);
		expensesList.add(phoneBillExpense);
		expensesList.add(shoppingBillExpense);
		expensesList.add(waterBillExpense);
		expensesList.add(gasBillExpense);
		do {
			ui.displayExpenses(expensesList);
			ui.displayAmount(amount);
			System.out.println("Choose a number 1~5 to edit its expense :");
			//validation input id is number
			Validation.validate(sc);
			//validation input is 1~5
			while(!Validation.validateRange(sc.nextInt())) {
				Validation.validate(sc);
			}
			//validation expense is a number
			Validation.validateDouble(sc);
			double input = sc.nextDouble();
			ui.getParticularExpense().setExpense(input);
			double total = 0;
			for (Expenses e : expensesList) {
				total +=  e.getExpense();
			}
			amount = 200000.00 - total;
		}while(true);
	}

}
