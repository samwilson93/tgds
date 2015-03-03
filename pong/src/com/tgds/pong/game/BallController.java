package com.tgds.pong.game;

import java.awt.Point;

public class BallController {

	/** the speed of the paddle */
	private static final int SPEED = 5;
	
	/** the initial angle that the ball begins moving towards */
	private static final int START_ANGLE = 45;

	/** the ball which is controlled by this controller */
	private final Ball ball;

	/**
	 * Constructor - create a new controller and the paddle to go along with it.
	 * 
	 * @param game the game in which this controller sits
	 * @param side the side of the playing field on which this controller
	 */
	public BallController(Game game) {
		int x, y;

		x = game.getHorizontalCentre();
		y = game.getVerticalCentre();

		ball = new Ball(new Point(x, y));
		ball.setMaxSpeed(SPEED);
		ball.setFriction(false);
	}

	/**
	 * moves ball in direction provided
	 */
	public void moveBall(Vector velocityVector) {
		ball.setVelocity(velocityVector);
	}

	/**
	 * @return the location of this controllers paddle.
	 */
	public Point getBallLoc() {
		return ball.getLoc();
	}

	/**
	 * @return ball
	 */
	public Ball getBall() {
		return ball;
	}

	/**
	 * starts ball moving at set speed, 	
	 */
	public void setStartVelocity() {
		Vector startVelocity = Vector.polar(SPEED, START_ANGLE);
		ball.setVelocity(startVelocity);
		
	}
}
