/**
 * File:     PaddleStopMovingCommand.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.commands;

import com.tgds.pong.game.Player;

/**
 * A command from a player to stop moving the paddle.
 * 
 * @author jdl
 */
public class PaddleStopMovingCommand extends PongCommand {

	/**
	 * Constructor
	 * 
	 * @param player the player to stop moving
	 */
	public PaddleStopMovingCommand(Player player) {
		super(player);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		getPlayer().getInputReceiver().stopPaddle();
	}

}
