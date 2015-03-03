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
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import com.tgds.pong.game.Ball;
import com.tgds.pong.game.Game;
import com.tgds.pong.game.Paddle;

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

	/** target FPS */
	private static final int TARGET_FPS = 60;

	/** the game which we are displaying */
	private final Game game;

	/** whether the game is running */
	private boolean running = true;

	/**
	 * Constructor
	 */
	public GamePanel(Game game) {
		this.game = game;

		setPreferredSize(new Dimension(game.getWidth(), game.getHeight()));
		setBackground(BACKGROUND_COLOUR);

		launchUpdateThread();
	}

	/**
	 * Launch the thread responsible for updating the graphics of this panel.
	 */
	private void launchUpdateThread() {
		Thread t = new Thread("UI Painting") {
			@Override
			public void run() {
				while (running) {
					try {
						Thread.sleep(1000 / TARGET_FPS);
					} catch (InterruptedException e) {
						// do nothing
					}
					repaint();
				}
			}
		};
		t.start();
	}

	/**
	 * Paint the graphics of the current game state
	 */
	@Override
	public void paintComponent(Graphics g) {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(),
		        BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		paintBackground(g2);
		paintNet(g2);
		paintPaddles(g2);
		paintBall(g2);
		g.drawImage(img, 0, 0, null);
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
		List<Paddle> paddles = game.getPaddles();
		for (Paddle paddle : paddles) {
			Shape s = paddle.getShape();
			Point loc = paddle.getLoc();
			AffineTransform transform = new AffineTransform();
			transform.translate(loc.x, loc.y);
			g.transform(transform);
			g.fill(s);
			try {
				transform = transform.createInverse();
			} catch (NoninvertibleTransformException e) {
				// this should never happen - only a translate has been applied,
				// and that is invertible
				throw new AssertionError(e);
			}
			g.transform(transform);
		}
	}

	/**
	 * Paint the ball
	 * 
	 * @param g the graphics instance to paint on
	 */
	private void paintBall(Graphics2D g) {
		g.setColor(BALL_COLOUR);
		Ball ball = game.getBallLocation();
		Shape s = ball.getShape();
		Point loc = ball.getLoc();
		AffineTransform transform = new AffineTransform();
		transform.translate(loc.x, loc.y);
		g.transform(transform);
		g.fill(s);
		try {
			transform = transform.createInverse();
		} catch (NoninvertibleTransformException e) {
			// this should never happen - only a translate has been applied,
			// and that is invertible
			throw new AssertionError(e);
		}
		g.transform(transform);
	}
}
