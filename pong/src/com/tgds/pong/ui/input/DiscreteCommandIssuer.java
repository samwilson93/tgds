/**
 * File:     DiscreteCommandIssuer.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

/**
 * Command issuer which issues discrete commands, i.e. commands which run on
 * 'fire and forget' principles, as distinct from continuous commands.
 * 
 * @author jdl
 */
public interface DiscreteCommandIssuer extends CommandIssuer {

	/**
	 * Issue a new command, given an input function to carry out.
	 * 
	 * @param func the function requested in the user input.
	 */
	void issueCommand(Function func);
}
