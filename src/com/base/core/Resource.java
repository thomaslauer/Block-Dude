package com.base.core;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Resource {
	public static Texture loadTexture(String fileName)
	{
		Texture texture = null;
		try {
			// tries to load a png file from res/textures/<FILENAME>.png
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/textures/" + fileName + ".png"));
		} catch (IOException e) {
			System.err.println("ERROR: Unable to load texture file");
			e.printStackTrace();
			System.exit(1);
		}
		return texture;
	}
}