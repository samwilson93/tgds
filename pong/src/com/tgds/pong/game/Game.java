/**
 * File:     Game.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.tgds.pong.commands.PlayerInputReceiver;
import com.tgds.pong.game.PaddleController.Side;

/**
 * The game.
 * 
 * @author jdl
 */
public class Game {
	/** the width of the game, in pixels */
	private static final int WIDTH = 600;
	/** the height of the game, in pixels */
	private static final int HEIGHT = 400;

	/** the paddle controllers */
	private final List<PaddleController> paddleControllers = new ArrayList<>();
	
	/** the ball */
	private BallController ballController = null;

	/** all the objects within the game that update with time */
	private final List<GameTimedObject> updateList = new ArrayList<>();

	/** the players playing the game */
	private final List<Player> players = new ArrayList<>();

	/** whether the game is currently running or not */
	private boolean running = false;

	/**
	 * Construct a new game.
	 */
	public Game() {
		PaddleController p1control = new PaddleController(Side.LEFT, this);
		Player p1 = new Player(p1control);
		PaddleController p2control = new PaddleController(Side.RIGHT, this);
		Player p2 = new Player(p2control);
		
		ballController = new BallController(this);

		players.add(p1);
		players.add(p2);
		paddleControllers.add(p1control);
		paddleControllers.add(p2control);

		updateList.add(p1control.getPaddle());
		updateList.add(p2control.getPaddle());
		updateList.add(ballController.getBall());
		
		ballController.setStartVelocity();

		setRunning(true);
		startGameLoop();
	}

	/**
	 * begin the main game loop
	 */
	private void startGameLoop() {
		int stepTime = 1000 / 60;
		Thread t = new Thread("Game Loop") {
			@Override
			public void run() {
				while (true) {
					if (isRunning()) {
						for (GameTimedObject obj : updateList) {
							obj.update();
						}
						long current = System.currentTimeMillis();
						try {
							Thread.sleep(stepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		t.start();
	}

	/**
	 * Add an object to the game to be updated in the game loop.
	 * 
	 * @param object the game object to add
	 */
	public void addTimedObject(GameTimedObject object) {
		updateList.add(object);
	}

	/**
	 * Remove an object from the game's list.
	 * 
	 * @param object the object to remove
	 */
	public void removeTimedObject(GameTimedObject object) {
		updateList.remove(object);
	}

	/**
	 * Set whether the game is running or not
	 * 
	 * @param value true if the game is running
	 */
	public void setRunning(boolean value) {
		running = value;
	}

	/**
	 * @return the value of running - true if the game is currently runnig
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @return the current location of the ball
	 */
	public Ball getBallLocation() {
		// TODO: implement this
		return ballController.getBall();
	}

	/**
	 * @return the current locations of the paddles
	 */
	public List<Paddle> getPaddles() {
		List<Paddle> result = new ArrayList<>();
		for (PaddleController controller : paddleControllers) {
			result.add(controller.getPaddle());
		}
		return result;
	}

	/**
	 * @return the player input receivers
	 */
	public List<? extends PlayerInputReceiver> getPlayerInputReceivers() {
		return paddleControllers;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @return the width of this game
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height of this game
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the horizontal centre of the playing field
	 */
	public int getHorizontalCentre() {
		return getWidth() / 2;
	}

	/**
	 * @return the vertical centre of the playing field
	 */
	public int getVerticalCentre() {
		return getHeight() / 2;
	}
}
