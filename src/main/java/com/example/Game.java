package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 //SWITCH????
public class Game {

	int[] frames = new int[10];
	List<Integer> roundScore = new ArrayList<>();
	int numberOfRollsThisFrame;
	int spare;
	int strike;
	int rounds;
	static final int LAST_FRAME = 10;


	void roll(int pinn) {
		checkIfLastRoundAndAddPoints(pinn);
		numberOfRollsThisFrame++;

		if (!strikeHit(pinn))
			roundScore.add(pinn);

		if (strikeHit(pinn)) {
			numberOfRollsThisFrame = 2;
			strike = 1;
		} else if (spareHit()) {
			spareHitEndRound();
		} else if (endOfRound()) {
			addRoundScore();
		}

	}

	 private void spareHitEndRound() {
		 spare = 1;
		 roundScore.clear();
		 endRound();
	 }

	 private boolean endOfRound() {
		 return numberOfRollsThisFrame == 2;
	 }

	 private void checkIfLastRoundAndAddPoints(int pinn) {
		 if (rounds == LAST_FRAME) {
			 addRoundTenBonus(pinn);
		 } else {
			 addBonusPoints(pinn);
		 }
	 }

	 private void addBonusPoints(int pinn) {
		 addSpareBonus(pinn);
		 addStrikeBonus(pinn);
	 }

	 private void addRoundTenBonus(int pinn) {
		if (spare == 1) {
			frames[rounds - 1] = 10 + pinn + pinn;
			resetSpareCounter();
		} else if (pinn == 10) {
			frames[rounds - 1] = frames[rounds - 1] + pinn;
			endRound();
		} else {
			frames[rounds - 1] = frames[rounds - 1] + pinn;

		}
	}

	private void addStrikeBonus(int pinn) {
		if (strike == 1) {
			frames[rounds] = 10 + pinn;
			strike++;
			endRound();
		} else if (strike == 2) {
			frames[rounds] = frames[rounds] + pinn;
			resetStrikeCounter();
			numberOfRollsThisFrame = 1;
			rounds++;
		}
	}

	private void resetSpareCounter() {
		spare = 0;
	}

	private void resetStrikeCounter() {
		strike = 0;
	}

	private void addSpareBonus(int pinn) {
		if (spare == 1) {
			frames[rounds] = 10 + pinn;
			resetSpareCounter();
			rounds++;
		}
	}

	private void addRoundScore() {
		frames[rounds] = frameScore();
		roundScore.clear();
		rounds++;
		endRound();
	}

	private boolean strikeHit(int pinn) {
		return firstRoll() && pinn == 10;
	}

	 private boolean firstRoll() {
		 return numberOfRollsThisFrame == 1;
	 }

	 private boolean spareHit() {
		return endOfRound() && frameScore() == 10;
	}

	private void endRound() {
		numberOfRollsThisFrame = 0;
	}

	int frameScore() {
		return roundScore.stream().mapToInt(Integer::intValue).sum();
	}

	int score() {
		return Arrays.stream(frames).sum();
	}
}
