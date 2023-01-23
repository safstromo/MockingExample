package com.example;

import java.util.ArrayList;
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

		score.add(pinn);
		if (strikeHit(pinn)) {
			numberOfRollsThisFrame = 0;
			strike = 1;
		} else if (spareHit()) {
			spare = 1;

		} else if (numberOfRollsThisFrame == 2) {
			addRoundScore();
		}

	}

	private void addRoundTenBonus(int pinn) {
		if (spare == 1) {
			frames[rounds - 1] = 10 + pinn + pinn;
			spare = 0;
		} else if (pinn == 10) {
			frames[rounds - 1] = frames[rounds - 1] + pinn;
			numberOfRollsThisFrame = 0;
		}else {
			frames[rounds - 1] = frames[rounds - 1] + pinn;

		}
	}

	private void addStrikeBonus(int pinn) {
		if (strike == 1) {
			frames[rounds] = 10 + pinn;
			strike++;
		} else if (strike == 2) {
			frames[rounds] = frames[rounds] + pinn;
			strike = 0;
			numberOfRollsThisFrame = 0;
		}
	}

	private void addSpareBonus(int pinn) {
		if (spare == 1) {
			frames[rounds] = 10 + pinn;
			spare = 0;
		}
	}

	private void addRoundScore() {
		rounds++;
		frames[rounds - 1] = frameScore();
		score.clear();
		numberOfRollsThisFrame = 0;
	}

	private boolean strikeHit(int pinn) {
		return numberOfRollsThisFrame % 2 == 1 && pinn == 10;
	}

	private boolean spareHit() {
		return numberOfRollsThisFrame % 2 == 0 && (score.get(numberOfRollsThisFrame - 1) + score.get(numberOfRollsThisFrame - 2) == 10);
	}

	int frameScore() {
		return score.stream().mapToInt(Integer::intValue).sum();
	}

}
