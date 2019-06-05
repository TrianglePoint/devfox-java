package com.baseball.action;

import com.baseball.bean.SBOBean;
import com.baseball.bean.ThreeNumberBean;

public class GameMasterAction {
	
	/*
	 * Create random number for answer.
	 * 
	 * range : 0 ~ 9
	 * array size : 3
	 */
	public void createAnswerNumber(ThreeNumberBean bean) {
		final int CHANGE_TO_INT = 10;
		int[] numbers = bean.getNumbers();
		
		/*
		 * Insert number without duplication.
		 */
		for(int i = 0; i < numbers.length;) {
			int number = (int)(Math.random() * CHANGE_TO_INT);
			
			if(checkDuplication(numbers, number, i)) {
				numbers[i] = number;
				i++;
			}
		}
		
		bean.setNumbers(numbers);
		
		return;
	}
	
	/*
	 * Check the number.
	 * if exist the same number, return false.
	 */
	private boolean checkDuplication(int[] numbers, int number, int max) {
		for(int i = 0; i < max; i++) {
			if(number == numbers[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Compare numbers and set the SBO.
	 */
	public void progressGame(ThreeNumberBean playerNumberBean, 
			ThreeNumberBean answerNumberBean, 
			SBOBean sboBean) {
		int[] playerNumbers = playerNumberBean.getNumbers();
		int[] answerNumbers = answerNumberBean.getNumbers();
		
		sboBean.setStrike(0);
		sboBean.setBall(0);
		
		for(int i = 0; i < playerNumbers.length; i++) {
			if(checkStrike(playerNumbers[i], answerNumbers[i])) {
				/*
				 * Strike!
				 */
				sboBean.countingStrike();
			}else if(checkBall(playerNumbers[i], answerNumbers)) {
				/*
				 * Ball.
				 */
				sboBean.countingBall();
			}
		}
		
		if(sboBean.getStrike() == 0 && sboBean.getBall() == 0) {
			/*
			 * Out...
			 */
			sboBean.countingOut();
		}
	}
	
	/*
	 * Check strike.
	 */
	private boolean checkStrike(int player, int answer) {
		return player == answer;
	}
	
	/*
	 * Check ball.
	 */
	private boolean checkBall(int player, int[] answers) {
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == player) {
				return true;
			}
		}
		
		return false;
	}
}
