package com.baseball.bean;

public class ThreeNumberBean {
	private int[] numbers;
	
	public ThreeNumberBean() {
		numbers = new int[3];
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}
