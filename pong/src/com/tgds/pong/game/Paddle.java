/**
 * File:     Paddle.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import com.tgds.pong.commands.PlayerInputReceiver.Direction;

/**
 * The paddles used to hit the ball and defend the goal. Respond to player
 * movement by moving.
 * 
 * @author jdl
 */
public class Paddle extends GameFieldObject {

	/** the width of the paddle */
	private static final int WIDTH = 20;
	/** the height of the paddle */
	private static final int HEIGHT = 100;

	/** the number of pixels the paddle moves each move */
	private static final int SPEED = 5;

	/**
	 * Construct a new paddle
	 * 
	 * @param loc
	 */
	public Paddle(Point loc) {
		super(loc, Paddle.getPaddleShape());
	}

	/**
	 * @Override Construct a new paddle
	 * 
	 * @param loc
	 */
	public void move(Direction direction) {
		int yMove = 0;
		if (direction == Direction.UP) {
			// negative because I think Java frames work with the y axis
			// increasing from top-left downwards
			yMove = -SPEED;
		} else {
			yMove = SPEED;
		}
		translate(new Point(0, yMove));
		System.out.println("Moved paddle. New location: " + getLoc());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean detectCollision(GameFieldObject other) {
		// TODO implement as part of issue #4
		return false;
	}

	/**
	 * Get a new shape to represent this paddle's shape
	 */
	private static Shape getPaddleShape() {
		int topLeftX = 0 - WIDTH / 2;
		int topLeftY = 0 - HEIGHT / 2;
		Shape shape = new Rectangle(topLeftX, topLeftY, WIDTH, HEIGHT);
		return shape;
	}
}
