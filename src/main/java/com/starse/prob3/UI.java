package com.starse.prob3;

public interface UI {
	void showInitialState();
	void decline();
	void approve();
	void showAvailList(int cash);
	boolean canPurchase(int id);
}
