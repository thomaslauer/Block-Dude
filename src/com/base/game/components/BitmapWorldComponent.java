package com.base.game.components;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.base.core.Bitmap;
import com.base.core.GameFile;
import com.base.core.GameObject;
import com.base.core.components.GameComponent;
import com.base.core.components.TextureRenderComponent;
import com.base.game.Block;

/**
 * Does the same thing as WorldComponent, just using a bitmap to store levels
 * @author Thomas Lauer
 *
 */
public class BitmapWorldComponent extends GameComponent
{
	public GameFile file;
	public HashMap<String, Bitmap> maps;
	
	public HashMap<String, Block> loadedBlockData;
	
	public int[][] data;
	public Bitmap currentBitmap = null;
	
	public int resolution;
	
	private static String startingName = "WORLD";
	
	/**
	 * Ctor takes a name for the component and defFile
	 * @param	name	name of the component
	 * @param 	defFile	file that loads the game parameters
	 */
	public BitmapWorldComponent(String name, String defFile)
	{
		super(name);
		this.file = new GameFile(defFile);
		this.maps = new HashMap<String, Bitmap>();
		
		loadedBlockData = new HashMap<String, Block>();
	}
	
	/**
	 * start method from GameComponent
	 * loads the bitmaps
	 */
	public void init()
	{
		loadBitmaps();
		
		// test code
		startMap("bitmap");
	}
	
	/**
	 * loads data from the def file, then loads the maps from the file names
	 */
	private void loadBitmaps()
	{
		maps.clear();
		loadedBlockData.clear();
		data = null;
		currentBitmap = null;
		ArrayList<JSONObject> objects = file.getJsonArray("blocks");
		
		for(JSONObject o : objects)
		{
			loadedBlockData.put((String) o.get("name"), new Block(o));
			System.out.println("adding block " + (String)o.get("name"));
		}
		
		ArrayList<String> bitmaps = file.getStringArray("bitmaps");
		
		for(String s : bitmaps)
		{
			maps.put(s, new Bitmap(s));
			System.out.println("loading bitmap " + s);
		}
		
		resolution = file.getInt("resolution");
	}
	
	/**
	 * builds the objects from a bitmap
	 * 
	 * @param	name	the name of the bitmap to load
	 */
	public void startMap(String name)
	{
		// loads the current bitmap
		currentBitmap = maps.get(name);
		
		// creates a new array to hold the data
		data = new int[getWidth()][getHeight()];
		
		// loads data from bitmap
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				for(String s : loadedBlockData.keySet())
				{
					if(loadedBlockData.get(s).getRGB() == currentBitmap.getRGB(x, y))
					{
						data[x][y] = loadedBlockData.get(s).id;
					}
				}
			}
		}
		
		// builds the scene
		buildMap();
	}
	
	public void buildMap()
	{
		// removes the previous scene
		removeAll();
		
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				for(String s : loadedBlockData.keySet())
				{
					//loadedBlockData.get(s).getRGB() == currentBitmap.getRGB(x, y)
					if(loadedBlockData.get(s).id == data[x][y])
					{
						parentObject.getChildObject("WorldObject").addObject(new GameObject((float)(x * resolution), y * resolution, 0, startingName + " " + x + " " + y)
						.addComponent(new TextureRenderComponent(loadedBlockData.get(s).getTexture(), resolution, resolution)));
						
						if(loadedBlockData.get(s).hasGravity())
						{
							parentObject.getChildObject("WorldObject").addComponent(new GravityComponent(x, y, loadedBlockData.get(s).id));
						}
					}
				}
			}
		}
	}
	
	public void update()
	{
		buildMap();
	}
	
	/**
	 * Removes all the objects 
	 */
	private void removeAll()
	{
		parentObject.deleteChildObject("WorldObject");
		parentObject.addObject(new GameObject("WorldObject"));
		//data = new int[getWidth()][getHeight()];
//		for(GameObject g : parentObject.children)
//		{
//			if(g.name.startsWith(startingName))
//			{
//				parentObject.children.remove(g);
//			}
//		}
	}
	
	/**
	 * gets the width of the current bitmap
	 * @return	width of the bitmap, or 0 if there is no current bitmap
	 */
	public int getWidth()
	{
		if(currentBitmap == null)
		{
			return 0;
		}
		return currentBitmap.getWidth();
	}
	
	/**
	 * gets the height of the current bitmap
	 * @return	height of the bitmap, or 0 if there is no current bitmap
	 */
	public int getHeight()
	{
		if(currentBitmap == null)
		{
			return 0;
		}
		return currentBitmap.getHeight();
	}
	
	/**
	 * used for gravity and collision detections
	 * @param mx starting x
	 * @param my starting y
	 * @param rx relative x
	 * @param ry relative y
	 * @return the datavalue from the data[][], or -1 if out of bounds
	 */
	public int getBlockRelative(int mx, int my, int rx, int ry)
	{
		//System.out.print("width: " + getWidth() + ", height: " + getHeight() + " " + mx + " ");
		try
		{
			return data[mx + rx][my + ry];
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			return -1;
		}
	}
	
	/**
	 * prints the contents of data[][]
	 */
	public void printArray()
	{
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				System.out.print(data[x][y] + " ");
			}
			System.out.println();
		}
	}
}
