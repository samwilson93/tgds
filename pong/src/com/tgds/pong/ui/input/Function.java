/**
 * File:     Function.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

/**
 * enumeration of expected functions
 * 
 * @author jdl
 */
public enum Function {
	UP_1("player1-up", 0),
	UP_2("player2-up", 1),
	DOWN_1("player1-down", 0),
	DOWN_2("player2-down", 1);

	/**
	 * the name of the property containing the keycode - null if there is no
	 * property for this function
	 */
	public String propertyName;

	/**
	 * the expected index of the player within the list of players this command
	 * relates to
	 */
	public int playerIndex;

	/** constructor */
	private Function(String property, int playerIndex) {
		this.propertyName = property;
		this.playerIndex = playerIndex;
	}
}