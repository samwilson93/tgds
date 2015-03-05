/**
 * File:     PaddleController.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.tgds.pong.commands.PlayerInputReceiver;

/**
 * Controller class for a paddle.
 * 
 * @author jdl
 */
public class PaddleController implements PlayerInputReceiver {

	/** the horizontal distance from the goal line that the paddle sits at */
	private static final int X_DISTANCE = 25;

	/** the acceleration vector of the paddle when it is being accelerated */
	private static final double ACCELERATION = 1;

	/** the angle of each direction */
	private final static Map<Direction, Vector> ACCELERATION_VECTORS =
	        new HashMap<>();
	static {
		ACCELERATION_VECTORS.put(
		        Direction.UP, Vector.polar(ACCELERATION, 270.0));
		ACCELERATION_VECTORS.put(
		        Direction.DOWN, Vector.polar(ACCELERATION, 90.0));
	}

	/** the coefficient of friction for the paddle */
	private static final double FRICTION_COEFFICIENT = 0.92;

	/** the maximum speed of the paddle */
	private static final int MAX_SPEED = 5;

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
		paddle.setMaxSpeed(MAX_SPEED);
		paddle.setFriction(true);
		paddle.setCoefficientOfFriction(FRICTION_COEFFICIENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void movePaddle(Direction direction) {
		paddle.setAcceleration(ACCELERATION_VECTORS.get(direction));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopPaddle() {
		paddle.setAcceleration(Vector.polar(0.0, 0.0));
	}

	/**
	 * @return the location of this controllers paddle.
	 */
	public Point getPaddleLoc() {
		return paddle.getLoc();
	}

	/**
	 * @return
	 */
	public Paddle getPaddle() {
		return paddle;
	}

	/**
	 * Side - the side of the playing field the paddle is on.
	 */
	public static enum Side {
		LEFT, RIGHT;
	}
}
