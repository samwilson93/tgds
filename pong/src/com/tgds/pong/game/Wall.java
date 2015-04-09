package com.tgds.pong.game;

import java.awt.Point;
import java.awt.Shape;

public class Wall extends GameFieldObject {
	
	
	/** the width of the paddle */
	private static int width;
	/** the height of the paddle */
	private static int height = 1;
	
	protected Wall(Vector loc, int width) {
		this.width = width;
		super(loc, new Rectangle(width, height), true);
	}	
}
