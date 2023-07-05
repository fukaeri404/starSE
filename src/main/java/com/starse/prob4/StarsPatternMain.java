package com.starse.prob4;

public class StarsPatternMain {

	public static void main(String[] args) {
		int rows = 5;
		leftSide(rows);
		leftSideReverse(rows);
		pyramidReverseMinusBy1(rows);
		pyramidReverseOddNumber(rows);
		pyramid(rows);

	}

	// left side triangle pattern
	static void leftSide(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// left side triangle pattern
	static void leftSideReverse(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void pyramid(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int k = 1; k <= rows - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	static void pyramidReverseMinusBy1(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int k = 1; k <= i - 1; k++) {
				System.out.print(" ");
			}
			for (int j = 5; j >= i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void pyramidReverseOddNumber(int rows) {
		for (int i = 1; i <= rows; i++) {
			for (int k = 1; k <= i - 1; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 9 - ((i - 1) * 2); j++) {// i felt so smart at this point T_T
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
