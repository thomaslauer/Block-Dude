package com.base.game.components;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

import com.base.core.Bitmap;
import com.base.core.GameFile;
import com.base.core.components.GameComponent;

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
	
	public BitmapWorldComponent(String name, String defFile)
	{
		this.file = new GameFile(defFile);
		this.maps = new HashMap<String, Bitmap>();
		
		loadedBlockData = new HashMap<String, Block>();
		loadBitmaps();
	}

	public void loadBitmaps()
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
	}
	
	public void StartMap(String name)
	{
		currentBitmap = maps.get(name);
		
		data = new int[getWidth()][getHeight()];
		
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				for(String s : loadedBlockData.keySet())
				{
					
					System.out.println("Block " + loadedBlockData.get(s).name + " : data " + loadedBlockData.get(s).getRGB());
					System.out.println("Pixel " + currentBitmap.getRGB(x, y));
					if(loadedBlockData.get(s).getRGB() == currentBitmap.getRGB(x, y))
					{
						System.out.println("WHOOT");
					}
				}
			}
		}
	}
	
	public int getWidth()
	{
		return currentBitmap.getWidth();
	}
	
	public int getHeight()
	{
		return currentBitmap.getHeight();
	}
}
