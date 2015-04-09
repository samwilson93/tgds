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
	
	/**Players current score */
	private int score;

	/** the input receiver handling this player's input */
	private final PlayerInputReceiver receiver;

	/**
	 * Construct a new player
	 * 
	 * @param receiver the input receiver handling this player's input
	 */
	public Player(PlayerInputReceiver receiver) {
		this.receiver = receiver;
		score = 0;
	}

	/**
	 * @return the input receiver handling this player's input
	 */
	public PlayerInputReceiver getInputReceiver() {
		return receiver;
	}

	/**
	 *  @return the players current score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score. This should really be ignored in favour of incrementScore.
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	/**
	 * Increments the players score by 1
	 */
	public void incrementScore(){
		score++;
	}
	
}
