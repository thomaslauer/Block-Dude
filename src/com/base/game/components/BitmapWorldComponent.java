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
	
	public BitmapWorldComponent(String name, String defFile)
	{
		this.file = new GameFile(defFile);
		this.maps = new HashMap<String, Bitmap>();
		
		loadedBlockData = new HashMap<String, Block>();
	}
	
	public void init()
	{
		loadBitmaps();
	}
	
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
		startMap("bitmap");
	}
	
	public void startMap(String name)
	{
		
		currentBitmap = maps.get(name);
		removeAll();
		data = new int[getWidth()][getHeight()];
		
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				for(String s : loadedBlockData.keySet())
				{
					
					//System.out.println("Block " + loadedBlockData.get(s).name + " : data " + loadedBlockData.get(s).getRGB());
					//System.out.println("Pixel " + currentBitmap.getRGB(x, y));
					if(loadedBlockData.get(s).getRGB() == currentBitmap.getRGB(x, y))
					{
						//System.out.println("The block found for spot " + x + ", " + y + " is " + s);
						
						parentObject.addObject(new GameObject(x * 64, y * 64, 0, "WORLD " + x + " " + y)
						.addComponent(new TextureRenderComponent(loadedBlockData.get(s).getTexture(), 64, 64)));
					}
				}
			}
		}
	}
	
	private void removeAll()
	{
		for(GameObject g : parentObject.children)
		{
			if(g.name.startsWith("WORLD"))
			{
				parentObject.children.remove(g);
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