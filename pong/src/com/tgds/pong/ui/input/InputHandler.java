/**
 * File:     InputHandler.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.List;

import com.tgds.pong.commands.Command;
import com.tgds.pong.commands.PaddleMoveCommand;
import com.tgds.pong.commands.PaddleStopMovingCommand;
import com.tgds.pong.commands.PlayerInputReceiver.Direction;
import com.tgds.pong.game.Player;

import config.InputConfig;

/**
 * Handles input from the human players, and converts it into commands which are
 * then executed.
 * 
 * @author jdl
 */
public class InputHandler implements KeyListener {

	/** the number of players input is configured for */
	private final static int PLAYERS = 2;

	/** the input configuration */
	private final InputConfig inputConfig;

	/** the players carrying out the input */
	private final List<Player> players;

	/**
	 * Construct a new InputHandler. Read in a set of properties for the player
	 * keys, and assign them to actions taken through the game.
	 * 
	 * @param propertiesStream the input stream to read properties from
	 * @param players the players in the game - it is expected that the size of
	 *            this array is equal to the number of players this input
	 *            handler is configured for, and that the players are in the
	 *            correct order in the list (i.e. player 1 is at index 0, player
	 *            2 at index 1, etc.)
	 * 
	 * @throws KeyMappingException if one of the expected keys cannot be mapped
	 *             for any reason - may include failure to read the properties
	 *             file, or missing or malformed properties within it.
	 */
	public InputHandler(InputStream propertiesStream, List<Player> players) {
		if (players.size() != PLAYERS) {
			throw new AssertionError("Unexpected number of players.");
		} else {
			this.players = players;
		}
		inputConfig = new InputConfig(propertiesStream);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		Player player = decodePlayer(key);
		Function func = inputConfig.getFunction(key);
		if (func != null) {
			Command com = new PaddleStopMovingCommand(player);
			com.execute();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		Player player = decodePlayer(key);
		Direction direction;
		Function func = inputConfig.getFunction(key);
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
			Command com = new PaddleMoveCommand(player, direction);
			com.execute();
		}
	}

	/**
	 * decode a key press into the player who pressed it
	 * 
	 * @param keycode the code of the pressed key
	 * @return the player who pressed the key (or null, if the key does not
	 *         correspond to a particular player)
	 */
	private Player decodePlayer(int keyCode) {
		Function func = inputConfig.getFunction(keyCode);
		if (func == null) {
			return null;
		}
		int index = func.playerIndex;
		return players.get(index);
	}
}
