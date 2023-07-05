package com.starse.prob7;

import java.util.ArrayList;

public class FindSameItemMain {
	public static void main(String[] args) {
		String[] allThings = { "Pen", "Cat", "Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow", "Pen", "Cat",
				"Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow" };
		ArrayList<String> nonRepeat = new ArrayList<>();
		for (String thing : allThings) {
			if (nonRepeat.isEmpty())
				nonRepeat.add(thing);
			else {
				for (int i = 0; i < nonRepeat.size(); i++) {
					if(nonRepeat.get(i).equalsIgnoreCase(thing))break;
					if(i == nonRepeat.size()-1) nonRepeat.add(thing);
				}
			}
		}
		
		for(String nonR : nonRepeat) {
			int count = 0;
			for (String thing : allThings) {
				if(nonR == thing) {
					count++;
				}
			}
			System.out.println(nonR + ": " + count +" times");
		}
	}
}
