/**
 * File:     Player.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import com.tgds.pong.commands.PlayerInputReceiver;

/**
 * The players in the game.
 * 
 * @author jdl
 */
public class Player {

	/** the input receiver handling this player's input */
	private final PlayerInputReceiver receiver;

	/**
	 * Construct a new player
	 * 
	 * @param receiver the input receiver handling this player's input
	 */
	public Player(PlayerInputReceiver receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the input receiver handling this player's input
	 */
	public PlayerInputReceiver getInputReceiver() {
		return receiver;
	}
}
