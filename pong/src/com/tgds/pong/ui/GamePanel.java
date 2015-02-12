/**
 * File:     GamePanel.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import com.tgds.pong.game.Game;

/**
 * The panel which shows the game.
 * 
 * @author jdl
 */
public class GamePanel extends JPanel {

	/** generated UID */
	private static final long serialVersionUID = -864334892816537343L;

	/** background colour */
	private static final Color BACKGROUND_COLOUR = Color.BLACK;

	/** ball colour */
	private static final Color BALL_COLOUR = Color.RED;

	/** paddle colour */
	private static final Color PADDLE_COLOUR = Color.WHITE;

	/** net colour */
	private static final Color NET_COLOUR = Color.GRAY;

	/** the thickness of the net, in pixels */
	private static final int NET_THICKNESS = 2;

	/** the game which we are displaying */
	private final Game game;

	/**
	 * Constructor
	 */
	public GamePanel(Game game) {
		this.game = game;

		setPreferredSize(new Dimension(game.getWidth(), game.getHeight()));
		setBackground(BACKGROUND_COLOUR);
	}

	/**
	 * Paint the graphics of the current game state
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		paintBackground(g2);
		paintNet(g2);
		paintPaddles(g2);
		paintBall(g2);
	}

	/**
	 * Paint the background.
	 * 
	 * @param g the graphics instance to paint on
	 */
	public void paintBackground(Graphics2D g) {
		g.setColor(BACKGROUND_COLOUR);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * Paint the net in the middle of the court
	 * 
	 * @param g the graphics instance to paint on
	 */
	private void paintNet(Graphics2D g) {
		g.setColor(NET_COLOUR);

		int x = getWidth() / 2 - NET_THICKNESS / 2;
		int width = NET_THICKNESS;
		int y = 0;
		int height = getHeight();

		g.fillRect(x, y, width, height);
	}

	/**
	 * Paint the paddles
	 * 
	 * @param g the graphics instance to paint on
	 */
	private void paintPaddles(Graphics2D g) {
		g.setColor(PADDLE_COLOUR);
		List<Dimension> locs = game.getPaddleLocations();
		if (locs != null) {
			for (Dimension loc : locs) {
				System.out.println("Paddle painted at: " + loc);
				// TODO: implement this
			}
		}
	}

	/**
	 * Paint the ball
	 * 
	 * @param g the graphics instance to paint on
	 */
	private void paintBall(Graphics2D g) {
		g.setColor(BALL_COLOUR);
		Dimension loc = game.getBallLocation();
		if (loc != null) {
			System.out.println("Ball painted at: " + loc);
		}
		// TODO: implement this
	}
}
