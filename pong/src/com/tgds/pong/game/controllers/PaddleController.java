/**
 * File:     PaddleController.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game.controllers;

import java.util.HashMap;
import java.util.Map;

import com.tgds.common.game.entities.GameFieldEntity;
import com.tgds.common.util.Vector;
import com.tgds.pong.commands.PlayerInputReceiver;
import com.tgds.pong.game.PongGame;
import com.tgds.pong.game.Side;
import com.tgds.pong.game.Wall;
import com.tgds.pong.game.objects.Ball;
import com.tgds.pong.game.objects.Paddle;

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
	public PaddleController(Side side, PongGame game) {
		int x, y;
		switch (side) {
			case WEST:
				x = X_DISTANCE;
				break;
			case EAST:
				x = game.getWidth() - X_DISTANCE;
				break;
			default:
				// this should never happen
				throw new AssertionError("Invalid side provided.");
		}
		y = game.getVerticalCentre();

		paddle = new Paddle(Vector.cartesian(x, y));
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
	 * Respond to a detected collision with another object.
	 * 
	 * @param other the other object
	 */
	private void reactCollision(GameFieldEntity other) {
		Class<?> otherClass = other.getClass();
		if (otherClass == Wall.class) {
			Vector noVelocity = Vector.cartesian(0, 0);
			paddle.setVelocity(noVelocity);
		}
		if (otherClass == Ball.class) {
			// Do nothing (As the ball will move)
			// TODO: Remove this if statement, is just for explanations sake
		}
		// And hopefully it won't collide with another paddle otherwise we might
		// have some problems
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
	public Vector getPaddleLoc() {
		return paddle.getLoc();
	}

	/**
	 * @return
	 */
	public Paddle getPaddle() {
		return paddle;
	}
}
