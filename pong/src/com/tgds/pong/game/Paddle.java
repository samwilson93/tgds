/**
 * File:     Paddle.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;

import com.tgds.pong.game.PlayerInputReceiver.Direction;

/**
 * The paddles used to hit the ball and defend the goal. Respond to player
 * movement by moving.
 * 
 * @author jdl
 */
public class Paddle extends GameFieldObject {
	
	private int yLocation = 0;
	
	/**
	 * Construct a new paddle
	 * 
	 * @param loc
	 */
	public Paddle(Point loc) {
		super(loc);
	}
	
	/**
	 * @Override
	 * Construct a new paddle
	 * 
	 * @param loc
	 */
	public void move(Direction direction) {
		if (direction == Direction.UP) {
			//negative because I think Java frames work with the y axis increasing from top-left downwards
			yLocation--;
		} else {
			yLocation++;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean detectCollision(GameFieldObject other) {
		// TODO implement as part of issue #4
		return false;
	}

}
