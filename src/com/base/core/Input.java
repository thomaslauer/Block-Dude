package com.base.core;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

/**
 * Input class to handle the input.
 * To add a new key use addKey, and use isKeyDown to read if a key is pressed.
 * Keys are all mapped to names to allow customization and key maps.
 * 
 * @author Thomas Lauer
 *
 */
public class Input {
	public static HashMap<String, Integer> registeredKeys = new HashMap<String, Integer>();
	public static HashMap<String, Boolean> keyState = new HashMap<String, Boolean>();
	
	/**
	 * adds a key to the key map
	 * @param name name of key
	 * @param keyCode key code, use Keyboard to get key constants
	 */
	public static void addKey(String name, int keyCode)
	{
		registeredKeys.put(name, keyCode);
		keyState.put(name, false);
	}
	
	/**
	 * polls the input
	 */
	public static void poll()
	{
		for(String key : keyState.keySet())
		{
			keyState.put(key, false);
		}
		
		for(String key : registeredKeys.keySet())
		{
			if(Keyboard.isKeyDown(registeredKeys.get(key)))
			{
				keyState.put(key, true);
			}
			else
			{
				keyState.put(key, false);
			}
		}
	}
	
	/**
	 * checks if a certain key is pressed
	 * @param key the key
	 * @return if the key is down
	 */
	public static boolean isKeyDown(String key)
	{
		return keyState.get(key);
	}
}
