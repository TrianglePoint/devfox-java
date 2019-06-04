package com.baseball.front;

import com.baseball.action.GameMasterAction;
import com.baseball.bean.SBOBean;
import com.baseball.bean.ThreeNumberBean;

public class NumberBaseBall {

	public static void main(String[] args) {
		NumberBaseBall numberBaseBall = new NumberBaseBall();
		numberBaseBall.onBoot();
	}
	
	public void onBoot() {
		GameMasterAction gameMaster = new GameMasterAction();
		
		ThreeNumberBean numberBean = new ThreeNumberBean();
		ThreeNumberBean answerNumberBean = new ThreeNumberBean();
		SBOBean sboBean = new SBOBean();
		
		while(true) {
			System.out.println("");
		}
	}

}
