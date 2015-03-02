/**
 * File:     PlayerInputReceiver.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.commands;


/**
 * Receiver for player input. Any player will call these methods in order to
 * control a paddle.
 * 
 * @author jdl
 */
public interface PlayerInputReceiver {

	/**
	 * receive a movement command and respond to it.
	 * 
	 * @param direction the direction of the movement
	 */
	void movePaddle(Direction direction);

	/**
	 * receive a command to stop moving, and respond to it.
	 */
	void stopPaddle();

	/**
	 * Directions for moving a paddle in
	 */
	public enum Direction {
		UP,
		DOWN;
	}
}
