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
import java.io.InputStream;

import javax.swing.JFrame;

import com.tgds.pong.game.Game;

/**
 * Main frame and method for the game of Pong.
 * 
 * @author jdl
 */
public class GameFrame extends JFrame {

	/** generated UID */
	private static final long serialVersionUID = 4732876013889337077L;

	/** the panel containing the main game */
	private final GamePanel gamePanel;

	/**
	 * Constructor. Build the frame and show it.
	 */
	private GameFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pong");

		Game game = new Game();
		gamePanel = new GamePanel(game);
		getContentPane().add(gamePanel);
		pack();
		setVisible(true);
		InputStream is = new FileInputStream(
		        "resources/com/tgds/pong/ui/playerOptions.properties");
		InputHandler handler = new InputHandler(is, game.getPlayers());
		super.addKeyListener(handler);
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
