package com.starse.prob3;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineService {
	private static VendingMachineService vendingMachineService;
	private final static ArrayList<Item> itemList = new ArrayList<>();
	private final static ArrayList<Item> availList = new ArrayList<>();

	private VendingMachineService() {

	}

	void initializeData() {
		Item item1 = new Item(1, "Tea", 190);
		Item item2 = new Item(2, "Pure Water", 100);
		Item item3 = new Item(3, "Pepsi", 130);
		Item item4 = new Item(4, "Coffee", 150);
		Item item5 = new Item(5, "Energy Drink", 220);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
	}

	void displayInitialState() {
		for (Item item : itemList) {
			System.out.println(item.getId() + ". " + item.getName() + " (" + item.getPrice() + "yen)");
		}
	}

	int displayAvailList(double inputCash) {
		for (Item item : itemList) {
			if (inputCash >= item.getPrice()) {
				availList.add(item);
			}
		}
		if (availList.size() > 0) {
			System.out.println("Available items according to your input cash");
			System.out.println("===========================================");
			for (Item item : availList)
				System.out.println(item.getId() + ". " + item.getName() + " (" + item.getPrice() + "yen)");
		} else
			System.out.println("Sorry!There is nothing you can buy with such amount!!!");

		return availList.size();
	}

	boolean isEnough(int id) {
		boolean enough = false;
		if (availList != null && !availList.isEmpty()) {
			for (Item item : availList) {
				if (id == item.getId()) {
					enough = true;
					break;
				}
			}
		}
		return enough;
	}

	int getUserwanted(Scanner sc) {
		System.out.println("Please choose a item that you want from available items :");
		while (!sc.hasNextInt()) {
			System.out.println("Please enter item id which is a number : ");
			sc.next();
		}
		return sc.nextInt();
	}

	double getInputCash(Scanner sc) {
		System.out.println("Please input your cash : ");
		while (!sc.hasNextDouble()) {
			System.out.println("Please enter cash which is a number : ");
			sc.next();
		}
		return sc.nextDouble();
	}

	public static VendingMachineService getInstance() {
		if (vendingMachineService == null)
			vendingMachineService = new VendingMachineService();
		return vendingMachineService;
	}
}
