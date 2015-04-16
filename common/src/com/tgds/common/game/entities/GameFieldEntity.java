/**
 * File:     GameFieldEntity.java
 * Project:  common
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.common.game.entities;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import com.tgds.common.util.Vector;

/**
 * An item that may appear in the game field. Consists primarily of a shape and
 * a location. The shape represents the bounds of the object. Where the location
 * is, relative to the shape, is determined by the coordinates of the shape set
 * (presumably by implementing classes).
 * 
 * @author jdl
 */
public abstract class GameFieldEntity {

	/** the location of this object, within its field. */
	private Vector loc;

	/** the shape of this object, centred on its loc */
	private Shape shape;

	/**
	 * whether the object is solid: i.e. whether other solid objects bounce off
	 * it.
	 */
	private boolean solid;

	/**
	 * Constructor
	 * 
	 * @param loc the location of the object
	 * @param shope the shape of the object
	 * @param solid whether the object is solid
	 */
	protected GameFieldEntity(Vector loc, Shape shape, boolean solid) {
		this.loc = loc;
		this.shape = shape;
		this.solid = solid;
	}

	/**
	 * Check a collision between this object and another
	 * 
	 * @param other another gameFieldObject to check for collisions with
	 * @return true if the two objects intersect
	 */
	public boolean checkCollision(GameFieldEntity other) {
		Shape thisShape = this.getShape();
		Shape otherShape = other.getShape();

		Rectangle2D thisRect = thisShape.getBounds2D();
		Rectangle2D otherRect = otherShape.getBounds2D();
		
		if (thisRect.intersects(otherRect)) {
			System.out.println("" + this + "\t\t collided with \t\t" + other);
			return true;
		}
		return false;
	}

	/**
	 * Function to detect collisions using the checkCollision function and then
	 * react appropriately
	 * 
	 * @param other the object it may be colliding with
	 * @return returns true if function has acted correctly
	 */
	public abstract boolean detectCollision(GameFieldEntity other);

	/**
	 * Translate the location of this object within its field.
	 * 
	 * @param vector the new position of the object, relative to its current
	 *            position.
	 */
	protected void translate(Vector vector) {
		loc = loc.add(vector);
	}

	/**
	 * Set a new location for the object.
	 * 
	 * @param newLoc the new location
	 */
	protected void setLoc(Vector newLoc) {
		loc = newLoc;
	}

	/**
	 * @return the location of this object, within its field.
	 */
	public Vector getLoc() {
		return loc;
	}

	/**
	 * @return the shape of this object
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * @return the solid
	 */
	public boolean isSolid() {
		return solid;
	}

	/**
	 * @param solid the solid to set
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	/**
	 * @return the colour of the object
	 */
	public abstract Color getColour();
}
