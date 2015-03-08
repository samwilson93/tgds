/**
 * File:     ContinuousCommandIssuer.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.ui.input;

/**
 * A command issuer for issuing continuous commands - i.e. commands which start,
 * continue for some period of time, and then stop.
 * 
 * @author jdl
 */
public interface ContinuousCommandIssuer extends CommandIssuer {

	/**
	 * start a command.
	 * 
	 * @param func the function of the command to issue
	 * @return a ticket number, representing the command issued
	 */
	long startCommand(Function func);

	/**
	 * stop a command
	 * 
	 * @param the ticket number (given out by {@link #startCommand(Function)})
	 *            of the command to stop
	 */
	void stopCommand(long ticket);
}
