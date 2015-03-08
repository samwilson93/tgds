/**
 * File:     PaddleMovementCommandIssuer.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tgds.pong.commands.PaddleMoveCommand;
import com.tgds.pong.commands.PaddleStopMovingCommand;
import com.tgds.pong.commands.PlayerInputReceiver.Direction;
import com.tgds.pong.commands.PongCommand;
import com.tgds.pong.game.Player;

/**
 * @author jdl
 */
public class PaddleMovementCommandIssuer implements ContinuousCommandIssuer {

	/** the number of players input is configured for */
	private final static int PLAYERS = 2;

	/** the players in the game */
	private final List<Player> players;

	/**
	 * the commands which have already been started, referenced by their ticket
	 * numbers
	 */
	private final Map<Long, PongCommand> tickets = new HashMap<>();

	/** the next available ticket number */
	private long nextTicket = 0;

	/**
	 * Constructor
	 * 
	 * @param players the players in the game
	 */
	public PaddleMovementCommandIssuer(List<Player> players) {
		this.players = players;
		if (PLAYERS != players.size()) {
			throw new AssertionError("Unexpected number of players.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long startCommand(Function func) {
		Player player = decodePlayer(func);
		Direction direction;
		if (func != null) {
			switch (func) {
				case UP_1:
				case UP_2:
					direction = Direction.UP;
					break;
				case DOWN_1:
				case DOWN_2:
					direction = Direction.DOWN;
					break;
				default:
					direction = null;
			}
			PongCommand cmd = new PaddleMoveCommand(player, direction);
			cmd.execute();
			return addTicket(cmd);
		}
		throw new NullPointerException("Null function supplied to startCommand");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopCommand(long ticket) {
		PongCommand cmd = tickets.get(ticket);
		Player player = cmd.getPlayer();
		PaddleStopMovingCommand stop = new PaddleStopMovingCommand(player);
		stop.execute();
	}

	/**
	 * decode a key press into the player who pressed it
	 * 
	 * @param keycode the code of the pressed key
	 * @return the player who pressed the key (or null, if the key does not
	 *         correspond to a particular player)
	 */
	private Player decodePlayer(Function func) {
		if (func == null) {
			return null;
		}
		int index = func.playerIndex;
		return players.get(index);
	}

	/**
	 * Apply a ticket to a command, and return the ticket number
	 * 
	 * @param cmd the command to add a ticket for
	 * @return the ticket number for the command
	 */
	private long addTicket(PongCommand cmd) {
		long ticket = getTicket();
		tickets.put(ticket, cmd);
		return ticket;
	}

	/**
	 * Get the next ticket number and increment the counter
	 * 
	 * @return the ticket number
	 */
	private long getTicket() {
		return nextTicket++;
	}
}
