/**
 * File:     GameFrame.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui;

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
	private GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pong");

		gamePanel = new GamePanel(new Game());
		getContentPane().add(gamePanel);
		pack();
		setVisible(true);
	}

	/**
	 * Main method for running the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GameFrame();
	}

}
