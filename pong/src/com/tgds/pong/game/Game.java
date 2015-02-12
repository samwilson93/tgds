/**
 * File:     Game.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Dimension;
import java.util.List;

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
	public List<Dimension> getPaddleLocations() {
		// TODO: implement this
		return null;
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

}
