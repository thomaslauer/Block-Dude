package com.base.core;

import java.awt.image.BufferedImage;

public class Bitmap {
	
	private int[] data;
	private int width;
	private int height;
	
	public Bitmap(String fileName)
	{
		BufferedImage img = Resource.loadImage("bitmaps/" + fileName);
		width = img.getWidth();
		height = img.getHeight();
		
		data = new int[width * height];
		img.getRGB(0, 0, width, height, data, 0, width);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int getRGB(int x, int y)
	{
		return data[x + y * width];
	}
	
	public int getR(int x, int y)
	{
		return (data[x + y * width] >> 16) & 0x000000FF;
	}
	
	public int getG(int x, int y)
	{
		return (data[x + y * width] >> 8) & 0x000000FF;
	}
	
	public int getB(int x, int y)
	{
		return (data[x + y * width]) & 0x000000FF;
	}
	
	public static int FromRGB(int r, int g, int b)
	{
		//System.out.println("r: " + r + " g: " + g +  " b: " + b);
		return (255 << 24) + (r << 16) + (g << 8) + (b << 0);
	}
}