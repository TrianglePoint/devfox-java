package com.baseball.bean;

public class ThreeNumberBean {
	private final static int SIZE = 3;
	
	private int[] numbers;
	
	public ThreeNumberBean() {
		numbers = new int[getSize()];
	}
	
	
	public static int getSize() {
		return SIZE;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}
