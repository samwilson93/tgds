package com.tgds.pong.game;

import java.awt.Color;
import java.awt.Rectangle;

import com.tgds.pong.game.objects.GameFieldObject;

public class Wall extends GameFieldObject {

	/** the width of the paddle */
	private static int width;
	/** the height of the paddle */
	private static int height = 1;

	protected Wall(Vector loc, int width) {
		super(loc, new Rectangle(width, height), true);
		this.width = width;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColour() {
		// TODO Auto-generated method stub
		return Color.ORANGE;
	}
}
