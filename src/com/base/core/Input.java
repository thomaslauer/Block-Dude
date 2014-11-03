package com.base.core;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public class Input {
	public static HashMap<String, Integer> registeredKeys = new HashMap<String, Integer>();
	public static HashMap<String, Boolean> keyState = new HashMap<String, Boolean>();
	
	public static void addKey(String name, int keyCode)
	{
		registeredKeys.put(name, keyCode);
		keyState.put(name, false);
	}
	
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
}
