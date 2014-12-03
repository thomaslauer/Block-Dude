package com.base.core;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.ArrayList;

/**
 * A simple class wrapper for the JSONObject that adds a few helpful methods
 * 
 * @author Thomas Lauer
 *
 */
public class GameFile {
	// JSONObject to represent the data in the GameFile
	protected JSONObject jsonObject;
	
	private static String fileExtension = ".gfile";
	
	// no argument constructor
	public GameFile()
	{
		jsonObject = new JSONObject();
	}
	
	// makes a GameFile from a given file name
	public GameFile(String fileName)
	{
		this();
		loadFromFile(fileName);
	}
	
	// returns the contents of the jsonObject (and then the file)
	public String toString()
	{
		return jsonObject.toString();
	}
	
	// saves the current object to a file
	public void saveToFile(String fileName)
	{
		try 
		{
			// makes a File object
			File file = new File("res/" + fileName + fileExtension);
			
			// if the file does not exist, create it
			if(!file.exists())
				file.createNewFile();
			
			// makes a bufferedWriter with the file
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			// writes the object as a string
			writer.write(toString());
			// closes the writer
			writer.close();
		} 
		catch (IOException e) 
		{
			// prints an error message
			System.out.println("ERROR: Could not create save file");
			e.printStackTrace();
		}
	}
	
	// loads a file from the disk into the memory
	public GameFile loadFromFile(String fileName)
	{
		try
		{
			// makes a new File object
			File file = new File("res/" + fileName + fileExtension);
			
			// makes a buffered reader with the file
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// variables for the data and for the current line being read
			String data = "";
			String line = "";
			
			// reads a line, and if it is not null, add it to the data
			while((line = reader.readLine()) != null)
			{
				data += line;
			}
			
			// closes the reader to clean up memory
			reader.close();
			
			// parses the data and sets it to the jsonObject
			jsonObject = (JSONObject) JSONValue.parse(data);
		}
		catch (Exception e) 
		{
			System.out.println("ERROR: Could not load from save file");
			e.printStackTrace();
		}
		return this;
	}
	
	// clears the jsonObject
	public void clearJsonObject()
	{
		jsonObject.clear();
	}
	
	// returns the jsonObject
	public JSONObject getJsonObject()
	{
		return jsonObject;
	}
	
	// adds a String to the jsonObject
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, String value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	// adds an integer
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, int value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	// adds a float
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, float value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	// adds a boolean
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, boolean value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	// adds a JSONObject
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, JSONObject value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	
	//TODO: don't use primitives and instead use separate lists of each type
	@SuppressWarnings("unchecked")
	public GameFile setTag(String key, ArrayList<?> value)
	{
		jsonObject.put(key, value);
		return this;
	}
	
	public String getString(String key)
	{
		return (String) jsonObject.get(key);
	}
	
	public int getInt(String key)
	{
		Long value = (Long) jsonObject.get(key);
		return value.intValue();
	}
	
	public float getFloat(String key)
	{
		return (float) jsonObject.get(key);
	}
	
	public boolean getBoolean(String key)
	{
		return (boolean) jsonObject.get(key);
	}
	
	public JSONObject getObject(String key)
	{
		return (JSONObject) jsonObject.get(key);
	}
	
	public ArrayList<?> getArray(String key)
	{
		return (ArrayList<?>) jsonObject.get(key);
	}
}
