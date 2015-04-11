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

import javax.swing.JFrame;

import com.tgds.common.config.ConfigurationException;
import com.tgds.common.config.InputConfig;
import com.tgds.common.ui.GamePanel;
import com.tgds.pong.game.PongGame;
import com.tgds.pong.ui.input.Function;
import com.tgds.pong.ui.input.InputHandler;
import com.tgds.pong.ui.input.PaddleMovementCommandDispatcher;

/**
 * Main frame and method for the game of Pong.
 * 
 * @author jdl
 */
public class GameFrame {

	/** the panel containing the main game */
	private final GamePanel gamePanel;

	/** the frame holding it all together */
	private final JFrame frame;

	/**
	 * Constructor. Build the frame and show it.
	 * 
	 * @throws ConfigurationException
	 */
	private GameFrame() throws IOException, ConfigurationException {

		PongGame game = new PongGame();
		gamePanel = new GamePanel(game);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pong");
		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setVisible(true);
		InputConfig<Function> config = new InputConfig<>(new FileInputStream(
		        "resources/com/tgds/pong/ui/playerOptions.properties"),
		        Arrays.asList(Function.values()));
		InputHandler handler = new InputHandler(config,
		        new PaddleMovementCommandDispatcher(game.getPlayers()));
		frame.addKeyListener(handler);
	}

	/**
	 * Main method for running the game.
	 * 
	 * @param args
	 * @throws ConfigurationException
	 */
	public static void main(String[] args) throws IOException,
	        ConfigurationException {
		new GameFrame();
	}

}
