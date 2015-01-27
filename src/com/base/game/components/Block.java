package com.base.game.components;

import org.json.simple.JSONObject;

public class Block {
	private byte r;
	private byte g;
	private byte b;
	private String texture;
	public String name;
	
	public Block(JSONObject data)
	{
		
	}
	
	public byte getR() {
		return r;
	}
	
	public byte getG() {
		return g;
	}
	
	public byte getB() {
		return b;
	}

	public String getTexture() {
		return texture;
	}
}
