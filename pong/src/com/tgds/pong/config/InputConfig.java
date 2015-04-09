/**
 * File:     InputConfig.java
 * Project:  pong
 * 
 * Copyright Templecombe Game Development Society, 2015.
 * All rights reserved. 
 */
package com.tgds.pong.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.tgds.pong.ui.input.Function;
import com.tgds.pong.ui.input.KeyMappingException;

/**
 * Configuration of the user input. Loads input config from wherever it is
 * saved, and provides accessors for the various options for an input handler.
 * 
 * @author jdl
 */
public class InputConfig {

	/** the mapping of keys to game functions */
	private final Map<Integer, Function> keyMap;

	/**
	 * Construct a new input configuration. Involves reading in a collection of
	 * properties from an input stream to configure the input
	 * 
	 * @param propertiesStream the input stream containing the properties
	 */
	public InputConfig(InputStream propertiesStream) {
		try {
			Properties properties = PropertiesReader
			        .readProperties(propertiesStream);
			keyMap = new HashMap<>();
			for (Function func : Function.values()) {
				String key = func.propertyName;

				// only get properties where we expect them
				if (key != null) {
					String val = properties.getProperty(key);
					if (val == null) {
						throw new KeyMappingException("Missing property: "
						        + key);
					}
					try {
						int keyVal = Integer.parseInt(val);
						keyMap.put(keyVal, func);
					} catch (NumberFormatException e) {
						throw new KeyMappingException("Malformed property: "
						        + key
						        + "; expected integer but got \"" + "\"", e);
					}
				}
			}
		} catch (IOException e) {
			throw new KeyMappingException("Could not read properties file.", e);
		}
	}

	/**
	 * Get the function associated with a given key.
	 * 
	 * @see KeyEvent for the values of keycode.
	 * 
	 * @param keycode the key value
	 * @return the function associated with it
	 */
	public Function getFunction(int keycode) {
		return keyMap.get(keycode);
	}
}
