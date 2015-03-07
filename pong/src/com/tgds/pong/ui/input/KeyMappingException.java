/**
 * File:     KeyMappingException.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

/**
 * Exception thrown when mapping of keys to actions fails for some reason.
 * 
 * @author jdl
 */
public class KeyMappingException extends RuntimeException {

	/**
	 * @param message
	 * @param cause
	 */
	public KeyMappingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public KeyMappingException(String message) {
		super(message);
	}

	/**  */
	private static final long serialVersionUID = 3748491940083250238L;

}
