package com.tgds.pong.game;

import java.awt.Color;
import java.awt.Rectangle;

import com.tgds.common.util.Vector;
import com.tgds.pong.game.objects.GameFieldObject;

public class Wall extends GameFieldObject {

	/** the height of the paddle */
	private static final int HEIGHT = 1;

	protected Wall(Vector loc, int width) {
		super(loc, new Rectangle(width, HEIGHT), true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColour() {
		// TODO change this
		return Color.ORANGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean detectCollision(GameFieldObject other) {
		// TODO Auto-generated method stub
		return false;
	}
}
