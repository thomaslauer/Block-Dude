package com.base.core;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Scanner;

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
	
	public void saveToFile(String fileName)
	{
		try 
		{
			File file = new File("res/" + fileName + ".gfile");
			if(!file.exists())
				file.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(getString());
			writer.close();
		} 
		catch (IOException e) 
		{
			System.out.println("ERROR: Could not create save file");
			e.printStackTrace();
		}
	}
	
	public GameFile loadFromFile(String fileName)
	{
		try
		{
			File file = new File("res/" + fileName + ".gfile");
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String data = "";
			String line = "";
			
			while((line = reader.readLine()) != null)
			{
				data += line;
			}
			
			jsonObject = (JSONObject) JSONValue.parse(data);
		}
		catch (Exception e) 
		{
			System.out.println("ERROR: Could not load from save file");
			e.printStackTrace();
		}
		return this;
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
