/**
 * File:     PaddleController.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;

import com.tgds.pong.commands.PlayerInputReceiver;

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

	/** the current direction of travel of the paddle - null if not moving */
	private Direction direction;

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
		direction = null;

		startMoveThread();
	}

	/**
	 * Start the thread to control movement of the paddle
	 */
	private void startMoveThread() {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// do nothing
					}
					if (direction != null) {
						paddle.move(direction);
					}
				}
			}
		};
		t.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void movePaddle(Direction direction) {
		this.direction = direction;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopPaddle() {
		direction = null;
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

	/**
	 * @return
	 */
	public Paddle getPaddle() {
		return paddle;
	}
}
