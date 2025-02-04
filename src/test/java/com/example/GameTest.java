package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
	Game game = new Game();

	@Test
	void addScoreToList() {
		game.roll(3);

		assertEquals(3, game.frameScore());
	}

	@Test
	void spareIsHit() {
		game.roll(2);
		game.roll(8);

		assertEquals(1, game.spare = 1);
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

	@Test
	void addTwoFrameScore() {
		game.roll(4);
		game.roll(4);
		game.roll(4);
		game.roll(4);

		assertEquals(16, Arrays.stream(game.frames).sum());


	}

	@Test
	void thirdFrameInCorrectIndex() {
		game.roll(4);
		game.roll(4);
		game.roll(4);
		game.roll(4);
		game.roll(2);
		game.roll(3);

		assertEquals(5, game.frames[2]);
	}

	@Test
	void addSpareToRoundScore() {
		game.roll(3);
		game.roll(7);
		game.roll(5);

		assertEquals(15, game.frames[0]);


	}

	@Test
	void addStrikeToRoundScore() {
		game.roll(3);
		game.roll(3);
		game.roll(10);
		game.roll(4);
		game.roll(4);

		assertEquals(18, game.frames[1]);

	}

	@Test
	void addScoreToLastFrameIfSpare() {
		game.rounds = 10;
		game.roll(3);
		game.roll(7);
		game.roll(8);

		assertEquals(26, game.frames[9]);
	}

	@Test
	void addScoreToLastFrameIfStrike() {
		game.rounds = 10;
		game.roll(10);
		game.roll(10);
		game.roll(10);

		assertEquals(30, game.frames[9]);
	}

	@Test
	void addScoreTwoStrikesLastFrame() {
		game.rounds = 10;
		game.roll(10);
		game.roll(10);
		game.roll(5);

		assertEquals(25, game.frames[9]);

	}

	@Test
	void totalScore() {

		game.roll(2);
		game.roll(2); // 4

		game.roll(3);
		game.roll(3); // 6

		game.roll(10);// 14

		game.roll(3);
		game.roll(1); // 4

		game.roll(8);
		game.roll(2); // 11

		game.roll(1);
		game.roll(1); // 2

		game.roll(3);
		game.roll(1); // 4

		game.roll(3);
		game.roll(1); // 4

		game.roll(1);
		game.roll(1); // 2

		game.roll(10);
		game.roll(1); // 11

		assertEquals(62, game.score());

	}

}