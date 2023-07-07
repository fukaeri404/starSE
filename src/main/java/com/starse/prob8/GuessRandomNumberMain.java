package com.starse.prob8;


public class GuessRandomNumberMain {

	public static void main(String[] args) {
		RandomNumberService service = RandomNumberService.getInstance();
		service.guess();
	}

}
