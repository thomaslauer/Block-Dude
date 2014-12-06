package com.base.game.components;

import java.util.ArrayList;

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
	public GameFile file;
	
	/**
	 * 2d array that holds the block codes
	 */
	public int[][] world;
	
	/**
	 * size of world in x and y blocks
	 */
	private int sizeX, sizeY;
	
	/**
	 * Makes a new component from a file, loading the size in x and y, along with all the data 
	 * from json into the 2d array
	 * @param fileName
	 */
	public WorldComponent(String fileName)
	{
		file = new GameFile(fileName);
		
		sizeX = file.getInt("SizeX");
		sizeY = file.getInt("SizeY");
		
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
				System.out.print(world[j][i]);
			}
			System.out.println();
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
