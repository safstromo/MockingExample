package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
	Game game = new Game();

	@Test
	void addScoreToList() {
		game.roll(3);

		assertEquals(3,game.frameScore());
	}

	@Test
	void spareIsHit() {
		game.roll(2);
		game.roll(8);

		assertEquals(1,game.spare = 1);
	}

	@Test
	void strikeIsHit() {
		game.roll(10);

		assertEquals(1, game.strike = 1);
	}

	@Test
	void addFrameScore() {
		game.roll(2);
		game.roll(4);

		assertEquals(6, Arrays.stream(game.frames).sum());

	}
}