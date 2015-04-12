/**
 * File:     GameFrame.java
 * Project:  common
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.common.ui;

import javax.swing.JFrame;

import com.tgds.common.game.Game;
import com.tgds.common.ui.input.KeyboardInputHandler;

/**
 * @author jdl
 */
public class GameFrame {
	/** the panel containing the main game */
	protected GamePanel gamePanel;
	/** the frame holding it all together */
	protected final JFrame frame;

	public GameFrame(String title) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setVisible(true);
	}

	/**
	 * Set the game panel
	 * 
	 * @param panel the panel to set
	 */
	private void setGamePanel(GamePanel panel) {
		if (gamePanel != null) {
			frame.getContentPane().remove(gamePanel);
		}
		this.gamePanel = panel;
		frame.getContentPane().add(gamePanel);
		frame.pack();
	}

	/**
	 * Set the game being played in the frame.
	 * 
	 * @param game the game to set.
	 */
	public void setGame(Game game) {
		gamePanel = new GamePanel(game);
		setGamePanel(gamePanel);
	}

	/**
	 * Add a keyboard input handler
	 * 
	 * @param handler the keyboard input handler to add
	 */
	public void addKeyboardInputHandler(KeyboardInputHandler<?> handler) {
		frame.addKeyListener(handler);
	}
}