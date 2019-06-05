package com.baseball.front;

import java.util.Scanner;

import com.baseball.action.GameMasterAction;
import com.baseball.bean.SBOBean;
import com.baseball.bean.ThreeNumberBean;

public class NumberBaseBall {
	/*
	 * Used for menu.
	 */
	final int EXIT_GAME = -1;
	final int RESTART_GAME = -2;
	final int SHOW_ANSWER = -3;
	
	/*
	 * Used for menu and check the inserted numbers.
	 */
	final int MINIMUM_NUMBER = 0;
	final int MAXIMUM_NUMBER = 9;
	
	public static void main(String[] args) {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		numberBaseBall.play();
	}
	
	/*
	 * Game Screen.
	 * 
	 * set the game environment using request other objects.
	 * print the menu, request that progress the game to game master.
	 */
	public void play() {
		/*
		 * Game master. create the answer number, progress the game.
		 */
		GameMasterAction gameMaster = new GameMasterAction();
		
		/*
		 * Player's numbers. 
		 */
		ThreeNumberBean playerNumberBean = new ThreeNumberBean();
		
		/*
		 * Answer's numbers.
		 */
		ThreeNumberBean answerNumberBean = new ThreeNumberBean();
		
		/*
		 * The storage of Strike, ball, out.
		 */
		SBOBean sboBean = new SBOBean();
		
		/*
		 * 1st game, 2nd game, 3rd game, ...
		 */
		int period;
		
		/*
		 * Last game is 9th.
		 */
		final int PERIOD_END = 9;
		
		/*
		 * Player win!
		 */
		final int THREE_STRIKE = 3;
		
		/*
		 * Three out! Game end!
		 */
		final int THREE_OUT = 3;
		
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * period = 1;
		 */
		period = bootGame(gameMaster, playerNumberBean, answerNumberBean, sboBean);
		
		while(true) {
			/*
			 * Player's number.
			 * Used for easily access to array.
			 */
			int[] numbers = playerNumberBean.getNumbers();
			
			/*
			 * Used for store the scanner values.
			 */
			String[] answers;
			
			/*
			 * Menu print.
			 */
			printMenuWithStatus(period, sboBean);
			
			/*
			 * First of all, insert to string array, and convert to number using function.
			 */
			answers = scanner.nextLine().split(" ");
			
			if(!insertNumberAndCheck(numbers, answers)) {
				/*
				 * Occur problem.
				 */
				continue;
			}
			
			/*
			 * Menu control.
			 */
			if(numbers[0] == EXIT_GAME) {
				break;
			}else if(numbers[0] == RESTART_GAME) {
				period = bootGame(gameMaster, playerNumberBean, answerNumberBean, sboBean);
				continue;
			}else if(numbers[0] == SHOW_ANSWER) {
				period = PERIOD_END;
			}
			
			playerNumberBean.setNumbers(numbers);
			
			/*
			 * Now, play the game.
			 */
			gameMaster.progressGame(playerNumberBean, answerNumberBean, sboBean);
			
			/*
			 * End one game.
			 */
			period++;
			
			/*
			 * Player win!
			 */
			if(sboBean.getStrike() == THREE_STRIKE) {
				System.out.println("You win!");
				printAnswer(answerNumberBean.getNumbers());
				
				/*
				 * Game reboot.
				 */
				period = bootGame(gameMaster, playerNumberBean, answerNumberBean, sboBean);
			}
			
			/*
			 * Game over.
			 */
			if(period > PERIOD_END || sboBean.getOut() == THREE_OUT) {
				System.out.println("Game Over");
				printAnswer(answerNumberBean.getNumbers());
				
				/*
				 * Game reboot.
				 */
				period = bootGame(gameMaster, playerNumberBean, answerNumberBean, sboBean);
			}
		}
		
		/*
		 * End game.
		 */
		scanner.close();
		System.out.println("Byebye!");
	}
	
	private int bootGame(GameMasterAction gameMaster, 
			ThreeNumberBean playerNumberBean, 
			ThreeNumberBean answerNumberBean, 
			SBOBean sboBean) {
		int[] numbers = new int[ThreeNumberBean.getSize()];
		
		System.out.println("-----BOOTING------");
		
		
		playerNumberBean.setNumbers(numbers);
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
	 * Print the menu.
	 */
	private void printMenuWithStatus(int period, SBOBean sboBean) {
		System.out.println("\nGame " + period 
				+ "\nStrike " + sboBean.getStrike()
				+ " | Ball " + sboBean.getBall()
				+ " | Out " + sboBean.getOut()
				+ "\nInsert the three numbers to do play, "
				+ "or end : " + EXIT_GAME + ", "
				+ "restart : " + RESTART_GAME + ", " 
				+ "show answer : " + SHOW_ANSWER 
				+ "\nRange : " + MINIMUM_NUMBER + " ~ " + MAXIMUM_NUMBER);
	}
	
	/*
	 * Print the answer.
	 */
	private void printAnswer(int[] answerNumbers) {
		System.out.print("Answer : ");
		for(int i = 0; i < answerNumbers.length; i++) {
			System.out.print(answerNumbers[i] + " ");
		}
		System.out.println();
	}
	
	/*
	 * Check the correct number, insert too.
	 */
	private boolean insertNumberAndCheck(int[] numbers, String[] answers) {
		if(answers.length > ThreeNumberBean.getSize()) {
			System.out.println("ERROR - Maximum command size is " + ThreeNumberBean.getSize());
			return false;
		}
		
		for(int i = 0; i < numbers.length; i++) {
			try {
				numbers[i] = Integer.parseInt(answers[i]);
				if(answers.length == 1 && 
						(numbers[0] == EXIT_GAME || numbers[0] == RESTART_GAME || 
						numbers[0] == SHOW_ANSWER)
				){
					/*
					 * Program end on upper.
					 */
					return true;
				}
				
				if(numbers[i] < MINIMUM_NUMBER || numbers[i] > MAXIMUM_NUMBER) {
					System.out.println("ERROR - Range : " + 
							MINIMUM_NUMBER + " ~ " + 
							MAXIMUM_NUMBER);
					
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
