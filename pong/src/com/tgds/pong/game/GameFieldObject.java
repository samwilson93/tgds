/**
 * File:     GameFieldObject.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;

/**
 * An item that may appear in the game field.
 * 
 * @author jdl
 */
public abstract class GameFieldObject {

	/**
	 * the location of this object, within its field.
	 */
	private Point loc;

	/**
	 * Constructor
	 * 
	 * @param loc the location of the object
	 */
	protected GameFieldObject(Point loc) {
		this.loc = loc;
	}

	/**
	 * Detect a collision between this object and another
	 * 
	 * @param other another gameFieldObject to check for collisions with
	 * @return true if the two objects intersect
	 */
	public abstract boolean detectCollision(GameFieldObject other);

	/**
	 * Translate the location of this object within its field.
	 * 
	 * @param vector the new position of the object, relative to its current
	 *            position.
	 */
	protected void translate(Point vector) {
		loc.translate(vector.x, vector.y);
	}

	/**
	 * Set a new location for the object.
	 * 
	 * @param newLoc the new location
	 */
	protected void setLoc(Point newLoc) {
		loc = newLoc;
	}

	/**
	 * @return the location of this object, within its field.
	 */
	public Point getLoc() {
		return loc;
	}
}
