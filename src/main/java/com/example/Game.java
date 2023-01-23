package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	int[] frames = new int[10];
	List<Integer> score = new ArrayList<>();
	int numberOfRollsThisFrame;
	int spare;
	int strike;
	int rounds;
	static final int LAST_FRAME = 10;


	void roll(int pinn) {
		if (rounds == LAST_FRAME) {
			addRoundTenBonus(pinn);
		} else {
			addSpareBonus(pinn);
			addStrikeBonus(pinn);
		}
		numberOfRollsThisFrame++;

		if (!strikeHit(pinn))
			score.add(pinn);

		if (strikeHit(pinn)) {
			numberOfRollsThisFrame = 2;
			strike = 1;
		} else if (spareHit()) {
			spare = 1;
			score.clear();
			endRound();

		} else if (numberOfRollsThisFrame == 2) {
			addRoundScore();
		}

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
		score.clear();
		rounds++;
		endRound();
	}

	private boolean strikeHit(int pinn) {
		return numberOfRollsThisFrame % 2 == 1 && pinn == 10;
	}

	private boolean spareHit() {
		return numberOfRollsThisFrame % 2 == 0 && (score.get(numberOfRollsThisFrame - 1) + score.get(numberOfRollsThisFrame - 2) == 10);
	}

	private void endRound() {
		numberOfRollsThisFrame = 0;
	}

	int frameScore() {
		return score.stream().mapToInt(Integer::intValue).sum();
	}

	int score() {
		return Arrays.stream(frames).sum();
	}
}
