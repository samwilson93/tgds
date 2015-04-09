/**
 * File:     GameField.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.game;

import java.util.ArrayList;
import java.util.Collection;

import com.tgds.pong.game.objects.GameFieldObject;

/**
 * The field in which the game takes place. Contains all the objects in the
 * game.
 * 
 * @author jdl
 */
public class GameField {
	/** the width of the field, in pixels */
	private static final int WIDTH = 600;
	/** the height of the field, in pixels */
	private static final int HEIGHT = 400;

	/** the objects in the field */
	private final Collection<GameFieldObject> entities =
	        new ArrayList<GameFieldObject>();

	/**
	 * Add an item to the game field
	 * 
	 * @param item the item to add
	 */
	public void addEntity(GameFieldObject item) {
		entities.add(item);
	}

	/**
	 * Remove an item from the game field
	 * 
	 * @param item the item to remove
	 */
	public void removeEntity(GameFieldObject item) {
		entities.remove(item);
	}

	/**
	 * @return the collection of entities in the field
	 */
	public Collection<GameFieldObject> getEntities() {
		return entities;
	}

	/**
	 * @return the width of the field
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height of the field
	 */
	public int getHeight() {
		return HEIGHT;
	}
}