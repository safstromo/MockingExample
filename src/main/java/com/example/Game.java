package com.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

	List<List> frames = new ArrayList<>();
	List<Integer> score = new ArrayList<>();
	int count;
	int spare;
	int strike;


	void roll(int pinn) {
		count++;
		score.add(pinn);
		if (spareHit()) {
			spare = 1;
		} else if (strikeHit(pinn)) {
			count += 2;
			strike = 1;
		}


	}

	private boolean strikeHit(int pinn) {
		return count % 2 == 1 && pinn == 10;
	}

	private boolean spareHit() {
		return count % 2 == 0 && (score.get(count - 1) + score.get(count - 2) == 10);
	}

	int score() {
		return score.stream().mapToInt(Integer::intValue).sum();
	}

}
