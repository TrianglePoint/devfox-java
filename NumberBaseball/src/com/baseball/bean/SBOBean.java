package com.baseball.bean;

public class SBOBean {
	private int strike;
	private int ball;
	private int out;
	
	public void countingStrike() {
		strike++;
	}
	public void countingBall() {
		ball++;
	}
	public void countingOut() {
		out++;
	}
	
	public int getStrike() {
		return strike;
	}
	public void setStrike(int strike) {
		this.strike = strike;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getOut() {
		return out;
	}
	public void setOut(int out) {
		this.out = out;
	}
}
