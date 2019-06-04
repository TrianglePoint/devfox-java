package com.baseball.action;

import com.baseball.bean.ThreeNumberBean;

public class GameMasterAction {
	public ThreeNumberBean createAnswerNumber(ThreeNumberBean bean) {
		int[] numbers = bean.getNumbers();
		
		/*
		 * Insert number without duplication.
		 */
		for(int i = 0; i < 3;) {
			int number = (int)(Math.random()*10);
			
			if(checkDuplication(numbers, number, i)) {
				numbers[i] = number;
				i++;
			}
		}
		
		bean.setNumbers(numbers);
		
		return bean;
	}
	
	private boolean checkDuplication(int[] numbers, int number, int max) {
		for(int i = 0; i < max; i++) {
			if(number == numbers[i]) {
				return false;
			}
		}
		
		return true;
	}
}
