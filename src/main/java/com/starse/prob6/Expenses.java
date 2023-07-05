package com.starse.prob6;

import java.util.ArrayList;

public sealed abstract class Expenses permits HouseRentExpense, PhoneBillExpense, ShoppingExpense, WaterSupplyExpense, GasBillExpense {

	private int id;
	private String name;
	private double expense;
	final static ArrayList<Expenses> EXPENSES_LIST = new ArrayList<>();

	public Expenses(int id, String name, double expense) {
		super();
		this.id = id;
		this.name = name;
		this.expense = expense;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

}
