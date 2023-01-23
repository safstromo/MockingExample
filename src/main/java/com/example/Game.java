package com.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

	int[] frames = new int[9];
	List<Integer> score = new ArrayList<>();
	int count;
	int spare;
	int strike;
	int rounds;


	void roll(int pinn) {
		count++;
		score.add(pinn);
		if (strikeHit(pinn)) {
			count += 2;
			strike = 1;
			spare = 1;
		} else if (spareHit()) {
			spare = 1;
		} else if (count == 2) {
			addRoundScore();
		}

	}

	private void addRoundScore() {
		rounds++;
		frames[rounds - 1] = frameScore();
		score.clear();
		count = 0;
	}

	private boolean strikeHit(int pinn) {
		return count % 2 == 1 && pinn == 10;
	}

	private boolean spareHit() {
		return count % 2 == 0 && (score.get(count - 1) + score.get(count - 2) == 10);
	}

	int frameScore() {
		return score.stream().mapToInt(Integer::intValue).sum();
	}

}
