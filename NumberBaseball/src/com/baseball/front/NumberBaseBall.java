package com.baseball.front;

import java.util.Scanner;

import com.baseball.action.GameMasterAction;
import com.baseball.bean.SBOBean;
import com.baseball.bean.ThreeNumberBean;

public class NumberBaseBall {

	public static void main(String[] args) {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		numberBaseBall.play();
	}
	
	public void play() {
		GameMasterAction gameMaster = new GameMasterAction();
		
		ThreeNumberBean numberBean = new ThreeNumberBean();
		ThreeNumberBean answerNumberBean = new ThreeNumberBean();
		SBOBean sboBean = new SBOBean();
		
		int period;
		final int PERIOD_END = 9;
		
		Scanner scanner = new Scanner(System.in);
		
		
		period = bootGame(gameMaster, numberBean, answerNumberBean, sboBean);
		
		while(true) {
			int[] numbers = numberBean.getNumbers();
			String[] answers;
			
			System.out.println("Insert the three numbers to do play, "
					+ "or end : -1, restart : -2");
			answers = scanner.nextLine().split(" ");
			
			if(!insertNumberAndCheck(numbers, answers)) {
				continue;
			}
			
			if(numbers[0] == -1) {
				break;
			}else if(numbers[0] == -2) {
				bootGame(gameMaster, numberBean, answerNumberBean, sboBean);
				continue;
			}
			
			numberBean.setNumbers(numbers);
			/*
			 * Now, play the game.
			 */
			
			
			/*
			 * End one game.
			 */
			period++;
			if(period > PERIOD_END) {
				System.out.println("Game Over");
				
				
			}
		}
		
		/*
		 * End game.
		 */
		System.out.println("Byebye!");
	}
	
	private int bootGame(GameMasterAction gameMaster, 
			ThreeNumberBean numberBean, 
			ThreeNumberBean answerNumberBean, 
			SBOBean sboBean) {
		int[] numbers = new int[3];
		
		System.out.println("-----BOOTING------");
		
		
		numberBean.setNumbers(numbers);
		gameMaster.createAnswerNumber(answerNumberBean);
		sboBean.setStrike(0);
		sboBean.setBall(0);
		sboBean.setOut(0);
		
		System.out.println("-----BOOT DONE------");
		
		/*
		 * First period is 1.
		 */
		return 1;
	}
	
	/*
	 * Check the correct number, insert too.
	 */
	private boolean insertNumberAndCheck(int[] numbers, String[] answers) {
		
		for(int i = 0; i < numbers.length; i++) {
			try {
				numbers[i] = Integer.parseInt(answers[i]);
				if(answers.length == 1 && 
						(numbers[0] == -1 || numbers[0] == -2)
				){
					/*
					 * Program end on upper.
					 */
					return true;
				}
				
				if(numbers[i] < 0 || numbers[i] > 9) {
					System.out.println("ERROR - Range : 0~9");
					
					return false;
				}
			}catch(ArrayIndexOutOfBoundsException aioobe) {
				System.out.println("ERROR - Wrong command");
				
				return false;
			}catch(NumberFormatException nfe) {
				System.out.println("ERROR - Only allowed the number");
				
				return false;
			}
		}
		return true;
	}

}
