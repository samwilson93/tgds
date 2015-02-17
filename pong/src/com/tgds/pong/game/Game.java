/**
 * File:     Game.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Construct a new game.
	 */
	public Game() {
		paddleControllers.add(new PaddleController(Side.LEFT, this));
		paddleControllers.add(new PaddleController(Side.RIGHT, this));
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
	public List<Point> getPaddleLocations() {
		List<Point> result = new ArrayList<>();
		for (PaddleController controller : paddleControllers) {
			result.add(controller.getPaddleLoc());
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
		return getHeight() / 2;
	}

	/**
	 * @return the vertical centre of the playing field
	 */
	public int getVerticalCentre() {
		return getWidth() / 2;
	}
}
