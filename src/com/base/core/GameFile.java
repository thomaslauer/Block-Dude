package com.base.core;

import org.json.simple.JSONObject;

public class GameFile {
	private JSONObject jsonObject;
	
	public GameFile()
	{
		jsonObject = new JSONObject();
	}
	
	public String getString()
	{
		return jsonObject.toString();
	}
	
	public void clearJsonObject()
	{
		jsonObject.clear();
	}
	
	public JSONObject getJsonObject()
	{
		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public void addTag(String key, String value)
	{
		jsonObject.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public void addTag(String key, int value)
	{
		jsonObject.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public void addTag(String key, float value)
	{
		jsonObject.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public void addTag(String key, boolean value)
	{
		jsonObject.put(key, value);
	}
}
