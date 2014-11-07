package com.base.core;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Scanner;

public class GameFile {
	// JSONObject to represent the data in the GameFile
	private JSONObject jsonObject;
	
	private static String fileExtension = ".gfile";
	
	// no argument constuctor
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
	public String getString()
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
			writer.write(getString());
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
			BufferedReader reader = new BufferedReader(new FileReader(file);
			
			// variables for the data and for the current line being read
			String data = "";
			String line = "";
			
			// reads a line, and if it is not null, add it to the data
			while((line = reader.readLine()) != null)
			{
				data += line;
			}
			
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
	public void addTag(String key, String value)
	{
		jsonObject.put(key, value);
	}
	
	// adds an int
	@SuppressWarnings("unchecked")
	public void addTag(String key, int value)
	{
		jsonObject.put(key, value);
	}
	
	// adds a float
	@SuppressWarnings("unchecked")
	public void addTag(String key, float value)
	{
		jsonObject.put(key, value);
	}
	
	// adds a boolean
	@SuppressWarnings("unchecked")
	public void addTag(String key, boolean value)
	{
		jsonObject.put(key, value);
	}
}
