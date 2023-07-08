package com.starse.prob7;

import java.util.HashSet;
import java.util.Set;

public class FindSameItemMain {
	public static void main(String[] args) {
		String[] allThings = { "Pen", "Cat", "Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow", "Pen", "Cat",
				"Dog", "Blue", "White", "Dog", "Pen", "Blue", "Yellow" };
//		ArrayList<String> nonRepeat = new ArrayList<>();
//		for (String thing : allThings) {
//			if (nonRepeat.isEmpty())
//				nonRepeat.add(thing);
//			else {
//				for (int i = 0; i < nonRepeat.size(); i++) {
//					if(nonRepeat.get(i).equalsIgnoreCase(thing))break;
//					if(i == nonRepeat.size()-1) nonRepeat.add(thing);
//				}
//			}
//		}

		Set<String> uniqueThing = new HashSet<>();
		for (String thing : allThings)
			uniqueThing.add(thing);

		for (String unique : uniqueThing) {
			int count = 0;
			for (String thing : allThings) {
				if (unique.equalsIgnoreCase(thing)) {
					count++;
				}
			}
			System.out.println(unique + ": " + count + " times");
		}
	}
}
