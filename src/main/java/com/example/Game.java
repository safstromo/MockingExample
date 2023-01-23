package com.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

	List<List> frames = new ArrayList<>();
	List<Integer> score = new ArrayList<>();
	int count;


	void roll(int pinn){
		count++;
		score.add(pinn);

	}

	int score(){
		return score.stream().mapToInt(Integer::intValue).sum();
	}

}
