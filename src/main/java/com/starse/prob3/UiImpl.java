package com.starse.prob3;

import java.util.ArrayList;

public class UiImpl implements UI {

	final ArrayList<Item> itemList = new ArrayList<Item>();
	final ArrayList<Item> availList = new ArrayList<Item>();

	public UiImpl() {
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


	public void showInitialState() {
		System.out.println("All Items");
		System.out.println("=========");
		clearAvailList();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
		System.out.println("->->->->[Please input your cash : ]->->->->");
	}

	
	public void decline() {
		// TODO Auto-generated method stub
		System.out.println("XXXX[Sorry!Your input number is not in your available list according to your cash!]XXXX");
	}

	
	public void approve() {
		System.out.println("<3<3<3<3[Thank you!Come Again!]<3<3<3<3");
	}

	
	public void showAvailList(int cash) {
		System.out.println("Available Items According to your cash");
		System.out.println("=====================================");
		for (Item item : itemList) {
			if (cash >= item.getPrice()) {
				System.out.println(item.toString());
				availList.add(item);
			}
		}
		System.out.println("->->->[Please enter a number you want to buy]->->->");
	}

	public boolean canPurchase(int id) {
		
		boolean valid = false;
		if (availList != null || !availList.isEmpty()) {
			for (Item item : availList) {
				if (id == item.getId()) {
					valid = true;
					break;
				}
			}
			if (valid)
				approve();
			else
				decline();
		}
		return valid;
	}
	
	private void clearAvailList() {
		if (availList != null || !availList.isEmpty())
			availList.clear();
	}

}
