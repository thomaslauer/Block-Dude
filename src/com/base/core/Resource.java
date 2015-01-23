package com.base.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.image.*;

import javax.imageio.*;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Resource class will handle all of the things not related to the GameFile class, such as
 * textures, sounds, and other stuff
 * 
 * @author Thomas Lauer
 * 
 */
public class Resource {
	
	/**
	 * holds loaded textures to keep from having to read from disk
	 */
	private static HashMap<String, Texture> loadedTextures = new HashMap<String, Texture>();
	
	/**
	 * loads a texture from a specified file name
	 * @param fileName path of the file, used as res/textures/NAME_HERE.png
	 * @return the texture
	 */
	public static Texture loadTexture(String fileName)
	{
		if(!loadedTextures.containsKey(fileName))
		{
			Texture texture = null;
			try {
				// tries to load a png file from res/textures/<FILENAME>.png
				texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/textures/" + fileName + ".png"));
				loadedTextures.put(fileName, texture);
			} catch (IOException e) {
				System.err.println("ERROR: Unable to load texture file");
				e.printStackTrace();
			}
		}
		
		return loadedTextures.get(fileName);
	}
	
	public static void unloadTexture(String fileName)
	{
		loadedTextures.remove(fileName);
	}
	
	public static HashMap<String, Texture> getLoadedTextures()
	{
		return loadedTextures;
	}
	
	public BufferedImage loadImage(String fileName)
	{
		BufferedImage img = null;
		
		try
		{
			img = ImageIO.read(new File("res/textures/" + fileName + ".png"));
		}
		catch(IOException ex)
		{
			System.err.println("ERROR: could not load image");
			ex.printStackTrace();
		}
		return img;
	}
}
