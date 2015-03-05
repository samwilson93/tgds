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
import java.awt.geom.Rectangle2D;

/**
 * The paddles used to hit the ball and defend the goal. Respond to player
 * movement by moving.
 * 
 * @author jdl
 */
public class Paddle extends MobileGameFieldObject {

	/** the width of the paddle */
	private static final int WIDTH = 20;
	/** the height of the paddle */
	private static final int HEIGHT = 100;

	/**
	 * Construct a new paddle
	 * 
	 * @param loc
	 */
	public Paddle(Point loc) {
		super(loc, Paddle.getPaddleShape());
	}

	/**
<<<<<<< HEAD
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
=======
	 * {@inheritDoc}
	 */
	@Override
	public boolean detectCollision(GameFieldObject other) {
		// TODO implement as part of issue #4
		return false;
>>>>>>> 65e43ca9444d71ce6ea0e3e529c8077fa8f20008
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

	@Override
	public void reactCollision(GameFieldObject other) {
		Class<?> otherClass = other.getClass();
		if(otherClass.getName() == "Wall"){
			//Stop moving that direction (Or we could have it bounce a bit?)
		}
		if(otherClass.getName() == "Ball"){
			//Do nothing (As the ball will move) 
			//TODO: Remove this if statement, is just for explanations sake
		}
		//And hopefully it won't collide with another paddle otherwise we might have some problems
	}
}
