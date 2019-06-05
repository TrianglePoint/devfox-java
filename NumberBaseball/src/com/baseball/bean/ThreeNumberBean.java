package com.baseball.bean;

public class ThreeNumberBean {
	private final static int SIZE = 3;
	
	private int[] numbers;
	
	public static int getSize() {
		return SIZE;
	}

	public ThreeNumberBean() {
		numbers = new int[getSize()];
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}
