package com.base.game;

import org.json.simple.JSONObject;

import com.base.core.Bitmap;

public class Block {
	
	public int id;
	
	private int r;
	private int g;
	private int b;
	private String texture;
	public String name;
	
	boolean gravity;
	
	public Block(JSONObject data)
	{
		id = (int) ((Number)data.get("id")).longValue();
		
		r = ((Number)data.get("colorR")).intValue();
		g = ((Number)data.get("colorG")).intValue();
		b = ((Number)data.get("colorB")).intValue();
		
		texture = (String) data.get("texture");
		name = (String) data.get("name");
		
		gravity = (boolean) data.get("gravity");
		//System.out.println("NEW BLOCK: r " + r + " g " + g + " b " + b);
	}
	
	public int getR() 
	{
		return r;
	}
	
	public int getG() 
	{
		return g;
	}
	
	public int getB() 
	{
		return b;
	}

	public String getTexture() 
	{
		return texture;
	}
	
	public String toString()
	{
		return name;
	}
	
	public int getRGB()
	{
		return Bitmap.FromRGB(r, g, b);
	}

	public boolean hasGravity() {
		return gravity;
	}
}