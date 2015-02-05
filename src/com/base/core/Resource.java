package com.base.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Scanner;
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
				texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/" + fileName + ".png"));
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
	
	public static BufferedImage loadImage(String fileName)
	{
		BufferedImage img = null;
		
		try
		{
			img = ImageIO.read(new File("res/" + fileName + ".png"));
		}
		catch(IOException ex)
		{
			System.err.println("ERROR: could not load image");
			ex.printStackTrace();
		}
		return img;
	}
	
	public static String loadTextToString(String fileName)
	{
		try {
			String tempString = "";
			Scanner input = new Scanner(new FileInputStream(new File(fileName)));
			while(input.hasNext())
			{
				tempString += input.nextLine();
			}
			input.close();
			return tempString;
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: could not load text file");
			e.printStackTrace();
			return "";
		}
	}
	
	public static void copyFolder(File src, File dest) throws IOException{
	 
	    if(src.isDirectory())
	    {
	
	   		//if directory not exists, create it
	   		if(!dest.exists()){
	   		   dest.mkdir();
	   		   System.out.println("Directory copied from " + src + "  to " + dest);
	   		}
	
	   		//list all the directory contents
	   		String files[] = src.list();
	
	   		for (String file : files) {
	   		   //construct the src and dest file structure
	   		   File srcFile = new File(src, file);
	   		   File destFile = new File(dest, file);
	   		   //recursive copy
	   		   copyFolder(srcFile,destFile);
	   		}
	
	   	}
	   	else
	   	{
	   		//if file, then copy it
	   		//Use bytes stream to support all file types
	   		InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dest); 
	        byte[] buffer = new byte[1024];
	        int length;
	        //copy the file content in bytes 
	        while ((length = in.read(buffer)) > 0)
	        {
	        	out.write(buffer, 0, length);
	    	}
	 
	    	in.close();
	    	out.close();
	    	System.out.println("File copied from " + src + " to " + dest);
	   	}
	}
	public static void delete(File file) throws IOException{
	 
	    if(file.isDirectory()){
	   		//directory is empty, then delete it
	    	if(file.list().length==0){
	    		file.delete();
	    		System.out.println("Directory is deleted : " + file.getAbsolutePath());
	    	}
	    	else
	    	{
	    		//list all the directory contents
	    		String files[] = file.list();
	    		for (String temp : files) {
	    			//construct the file structure
	    			File fileDelete = new File(file, temp);
	    			//recursive delete
	        	    delete(fileDelete);
	    		}
	 
	        	//check the directory again, if empty then delete it
	        	if(file.list().length==0){
	        		file.delete();
	        	    System.out.println("Directory is deleted : " + file.getAbsolutePath());
	        	}
	    	}
	 
	    }
	    else
	    {
	    	//if file, then delete it
	    	file.delete();
	    	System.out.println("File is deleted : " + file.getAbsolutePath());
	    }
	}
}
