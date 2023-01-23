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
		rounds++;
		score.add(pinn);
		if (strikeHit(pinn)) {
			count += 2;
			strike = 1;
			spare = 1;
		} else if (spareHit()) {
			spare = 1;
		} else if (count == 2) {
			frames[rounds] = frameScore();
			score.clear();
		}

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
