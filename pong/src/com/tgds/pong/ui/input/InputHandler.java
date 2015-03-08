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
import java.util.HashMap;
import java.util.Map;

import config.InputConfig;

/**
 * Handles input from the human players, and converts it into commands which are
 * then executed.
 * 
 * @author jdl
 */
public class InputHandler implements KeyListener {

	/** the input configuration */
	private final InputConfig inputConfig;

	/** the command issuer, for responding to inputs */
	private final ContinuousCommandIssuer commandIssuer;

	/**
	 * the keys which are currently down, and the command ticket numbers
	 * associated with them
	 */
	private final Map<Integer, Long> keysDown = new HashMap<>();

	/**
	 * Construct a new InputHandler. Read in a set of properties for the player
	 * keys, and assign them to actions taken through the game.
	 * 
	 * @param config the configuration of inputs
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
	public InputHandler(InputConfig config,
	        ContinuousCommandIssuer commandIssuer) {
		inputConfig = config;
		this.commandIssuer = commandIssuer;
	}

	/** {@inheritDoc} */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		Long ticket = keysDown.get(key);
		// we only care if the key released has a command attached to it:
		if (ticket != null) {
			commandIssuer.stopCommand(ticket);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		Function func = inputConfig.getFunction(key);
		if (func != null) {
			long ticket = commandIssuer.startCommand(func);
			keysDown.put(key, ticket);
		}
	}
}
