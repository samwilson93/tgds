/**
 * File:     Game.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.tgds.pong.commands.PlayerInputReceiver;
import com.tgds.pong.game.PaddleController.Side;

/**
 * The game.
 * 
 * @author jdl
 */
public class Game {
	/** the width of the game, in pixels */
	private static final int WIDTH = 600;
	/** the height of the game, in pixels */
	private static final int HEIGHT = 400;

	/** the paddle controllers */
	private final List<PaddleController> paddleControllers = new ArrayList<>();

	/** the players playing the game */
	private final List<Player> players = new ArrayList<>();

	/**
	 * Construct a new game.
	 */
	public Game() {
		PaddleController p1control = new PaddleController(Side.LEFT, this);
		Player p1 = new Player(p1control);
		PaddleController p2control = new PaddleController(Side.RIGHT, this);
		Player p2 = new Player(p2control);

		players.add(p1);
		players.add(p2);
		paddleControllers.add(p1control);
		paddleControllers.add(p2control);
	}

	/**
	 * @return the current location of the ball
	 */
	public Dimension getBallLocation() {
		// TODO: implement this
		return null;
	}

	/**
	 * @return the current locations of the paddles
	 */
	public List<Paddle> getPaddles() {
		List<Paddle> result = new ArrayList<>();
		for (PaddleController controller : paddleControllers) {
			result.add(controller.getPaddle());
		}
		return result;
	}

	/**
	 * @return the player input receivers
	 */
	public List<? extends PlayerInputReceiver> getPlayerInputReceivers() {
		return paddleControllers;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @return the width of this game
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height of this game
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the horizontal centre of the playing field
	 */
	public int getHorizontalCentre() {
		return getWidth() / 2;
	}

	/**
	 * @return the vertical centre of the playing field
	 */
	public int getVerticalCentre() {
		return getHeight() / 2;
	}
}
