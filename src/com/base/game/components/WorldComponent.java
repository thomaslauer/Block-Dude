package com.base.game.components;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.core.*;
import com.base.core.components.*;

/**
 * This class is used to store the data for the world in a two dimensional array.
 * It will also be in charge of building the world from the GameFile, complete
 * with children objects, components, and other configurations
 * 
 * @author Thomas Lauer
 *
 */
public class WorldComponent extends GameComponent
{
	/**
	 * The file holding json data for the level
	 */
	private GameFile file;
	
	/**
	 * 2d array that holds the block codes
	 */
	public int[][] world;
	
	/**
	 * size of world in x and y blocks
	 */
	private int sizeX, sizeY;
	
	/**
	 * size of each block
	 */
	private int resolution;
	
	/**
	 * holds the texture file names
	 */
	private HashMap<Integer, String> textureFiles;
	
	/**
	 * Makes a new component from a file, loading the size in x and y and other 
	 * data from json
	 * @param fileName
	 */
	public WorldComponent(String fileName)
	{
		file = new GameFile(fileName);
		textureFiles = new HashMap<Integer, String>();
		for(int i = 0; i < file.getInt("numOfTextures"); i++)
		{
			try
			{
				textureFiles.put(i, file.getString("T" + i));
				System.out.println("Photo file " + i + " " + file.getString("T" + i));
			}
			catch(Exception ex)
			{
				System.err.println("ERROR: could not find texture file name");
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * just calls the rebuild method
	 */
	public void init()
	{
		rebuild();
	}
	
	/**
	 * loads data from the file and puts it into the world array
	 */
	public void rebuild()
	{
		removeWorldObjects();
		sizeX = file.getInt("SizeX");
		sizeY = file.getInt("SizeY");
		resolution = file.getInt("Resolution");
		
		world = new int[sizeX][sizeY];
		
		for(int y = 0; y < sizeY; y++)
		{
			String levelCode = "L" + y;
			ArrayList<?> tempArray = file.getArray(levelCode);
			
			if(tempArray.size() != sizeX)
			{
				System.err.println("ERROR: Size of world file not matching expected");
				new Exception().printStackTrace();
				System.exit(0);
			}
			
			for(int x = 0; x < sizeX; x++)
			{
				long val = (long) tempArray.get(x);
				world[x][y] = (int) val;
			}
		}
		
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				//System.out.print(world[j][i]);
				if(world[j][i] > 0)
				{
					//System.out.println(world[j][i]);
					//System.out.println(textureFiles.get(world[j][i]-1));
					parentObject.addObject(new GameObject(j * resolution, i * resolution, 0, "WORLD " + j + " " + i)
							.addComponent(new TextureRenderComponent(textureFiles.get(world[j][i]-1), resolution, resolution)));
					
				}
			}
			//System.out.println();
		}
	}
	
	/*
	 * removes all the objects in the world graph
	 */
	public void removeWorldObjects()
	{
		for(GameObject g : parentObject.children)
		{
			if(g.name.startsWith("WORLD"))
			{
				parentObject.children.remove(g);
			}
		}
	}
	
	/**
	 * gets the GameFile
	 * @return the GameFile
	 */
	public GameFile getGameFile()
	{
		return file;
	}
	
	/**
	 * gets the size in x of the world array
	 * @return size in x
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * gets the size in y of the world array
	 * @return
	 */
	public int getSizeY() {
		return sizeY;
	}
}
