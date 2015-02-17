/**
 * File:     PaddleController.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;

/**
 * Controller class for a paddle.
 * 
 * @author jdl
 */
public class PaddleController implements PlayerInputReceiver {

	/** the horizontal distance from the goal line that the paddle sits at */
	private static final int X_DISTANCE = 25;

	/** the paddle which is controlled by this controller */
	private final Paddle paddle;

	/**
	 * Constructor - create a new controller and the paddle to go along with it.
	 * 
	 * @param game the game in which this controller sits
	 * @param side the side of the playing field on which this controller
	 */
	public PaddleController(Side side, Game game) {
		int x, y;
		switch (side) {
			case LEFT:
				x = X_DISTANCE;
				break;
			case RIGHT:
				x = game.getWidth() - X_DISTANCE;
				break;
			default:
				// this should never happen
				throw new AssertionError("Invalid side provided.");
		}
		y = game.getVerticalCentre();

		paddle = new Paddle(new Point(x, y));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void movePaddle(Direction direction) {
		paddle.move(direction);
	}

	/**
	 * @return the location of this controllers paddle.
	 */
	public Point getPaddleLoc() {
		return paddle.getLoc();
	}

	/**
	 * Side - the side of the playing field the paddle is on.
	 */
	public static enum Side {
		LEFT, RIGHT;
	}
}
