package com.tgds.pong.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * The ball used to score. Changes velocity only when hitting walls or paddles.
 * 
 * @author rae
 */
public class Ball extends MobileGameFieldObject {

	/** the width of the ball */
	private static final int WIDTH = 20;
	/** the height of the ball */
	private static final int HEIGHT = 20;

	/** the number of pixels the ball moves each move */
	private static final int SPEED = 5;
	
	/**
	 * Construct a new ball
	 * 
	 * @param loc
	 */
	public Ball(Point loc) {
		super(loc, Ball.getBallShape());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean detectCollision(GameFieldObject other) {
		if(this.checkCollision(other))
		{
			//TODO: REACT
			return true;
		} else if (!this.checkCollision(other)) {
			return true;
		}
		
		return false;
	}

	/**
	 * Get a new shape to represent this paddle's shape
	 */
	private static Shape getBallShape() {
		int topLeftX = 0 - WIDTH / 2;
		int topLeftY = 0 - HEIGHT / 2;
		Shape shape = new Rectangle(topLeftX, topLeftY, WIDTH, HEIGHT);
		return shape;
	}
}
