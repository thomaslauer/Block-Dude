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
	
	public BitmapWorldComponent(String name, String defFile)
	{
		this.file = new GameFile(defFile);
		this.maps = new HashMap<String, Bitmap>();
		
		loadedBlockData = new HashMap<String, Block>();
	}
	
	@SuppressWarnings("unchecked")
	public void loadFile()
	{
		ArrayList<JSONObject> objects = (ArrayList<JSONObject>) file.getArray("blocks");
		
		for(JSONObject o : objects)
		{
			loadedBlockData.put((String) o.get("name"), new Block(o));
			System.out.println("adding block " + (String)o.get("name"));
		}
		
		ArrayList<String> bitmaps = (ArrayList<String>)file.getArray("bitmaps");
		
		for(String s : bitmaps)
		{
			maps.put(s, new Bitmap(s));
			System.out.println("loading bitmap " + s);
		}
	}
}
