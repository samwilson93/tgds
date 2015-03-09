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

import javax.swing.JFrame;

import com.tgds.pong.game.Game;
import com.tgds.pong.ui.input.InputHandler;
import com.tgds.pong.ui.input.PaddleMovementCommandDispatcher;

import config.InputConfig;

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
	 */
	private GameFrame() throws IOException {

		Game game = new Game();
		gamePanel = new GamePanel(game);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pong");
		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setVisible(true);
		InputConfig config = new InputConfig(new FileInputStream(
		        "resources/com/tgds/pong/ui/playerOptions.properties"));
		InputHandler handler = new InputHandler(config,
		        new PaddleMovementCommandDispatcher(game.getPlayers()));
		frame.addKeyListener(handler);
	}

	/**
	 * Main method for running the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new GameFrame();
	}

}
