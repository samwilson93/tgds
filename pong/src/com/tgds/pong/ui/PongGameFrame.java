/**
 * File:     GameFrame.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import com.tgds.common.config.ConfigurationException;
import com.tgds.common.config.InputConfig;
import com.tgds.common.ui.GameFrame;
import com.tgds.common.ui.input.KeyboardInputHandler;
import com.tgds.pong.game.PongGame;
import com.tgds.pong.ui.input.PaddleMovementCommandDispatcher;
import com.tgds.pong.ui.input.PongGameFunction;

/**
 * Main frame and method for the game of Pong.
 * 
 * @author jdl
 */
public class PongGameFrame extends GameFrame {

	/**
	 * Constructor. Build the frame and show it.
	 * 
	 * @throws ConfigurationException
	 */
	private PongGameFrame() throws IOException, ConfigurationException {
		super("pong");

		PongGame game = new PongGame();
		super.setGame(game);

		InputConfig<PongGameFunction> config = new InputConfig<>(
		        new FileInputStream(
		                "resources/com/tgds/pong/ui/playerOptions.properties"),
		        Arrays.asList(PongGameFunction.values()));
		KeyboardInputHandler<PongGameFunction> handler = new KeyboardInputHandler<>(
		        config,
		        new PaddleMovementCommandDispatcher(game.getPlayers()));
		super.addKeyboardInputHandler(handler);
	}

	/**
	 * Main method for running the game.
	 * 
	 * @param args
	 * @throws ConfigurationException
	 */
	public static void main(String[] args) throws IOException,
	        ConfigurationException {
		new PongGameFrame();
	}
}
