/**
 * File:     GameFieldObject.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * An item that may appear in the game field.
 * 
 * @author jdl
 */
public abstract class GameFieldObject {

	/** the location of this object, within its field. */
	private Point loc;

	/** the shape of this object, centred on its loc */
	private Shape shape;

	/**
	 * Constructor
	 * 
	 * @param loc the location of the object
	 */
	protected GameFieldObject(Point loc, Shape shape) {
		this.loc = loc;
		this.shape = shape;
	}

	/**
	 * Check a collision between this object and another
	 * 
	 * @param other another gameFieldObject to check for collisions with
	 * @return true if the two objects intersect
	 */
	public boolean checkCollision(GameFieldObject other){
		Shape thisShape = this.getShape();
		Shape otherShape = other.getShape();
		
		Rectangle2D thisRect = thisShape.getBounds2D();
		Rectangle2D otherRect = otherShape.getBounds2D();
		
		if( thisRect.getX() < otherRect.getX() + otherRect.getWidth() &&  
			thisRect.getX() + thisRect.getWidth() > otherRect.getCenterX() &&
			thisRect.getY() < otherRect.getY() + otherRect.getHeight() &&
			thisRect.getHeight() + thisRect.getY() > otherRect.getY()){
			return true;
		}
		return false;
	}
	
	/**
	 * Function to detect collisions using the checkCollision function and then react appropriately 
	 * 
	 * @param other the object it may be colliding with
	 * @return returns true if function has acted correctly
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

	/**
	 * @return the shape of this object
	 */
	public Shape getShape() {
		return shape;
	}
}
