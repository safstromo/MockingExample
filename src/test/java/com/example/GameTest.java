package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
	Game game = new Game();

	@Test
	void addScoreToList() {
		game.roll(3);
		assertEquals(3,game.score());
	}

	@Test
	void spareIsHit() {
		game.roll(2);
		game.roll(8);

		assertEquals(1,game.spare = 1);
	}

}