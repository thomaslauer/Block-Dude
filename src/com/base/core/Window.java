package com.base.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * Controls the window used in the game. It handles things such as the size, 
 * name, projection matrix, clear color, and fps cap
 * 
 * @author Thomas Lauer
 *
 */
public class Window {
	// current display mode
	public static DisplayMode currentDisplayMode;
	
	/**
	 * Creates a display with the given dimensions 
	 * @param sx The x size in pixels
	 * @param sy The y size in pixels
	 */
	public static void createDisplay(int sx, int sy)
	{
		try
		{
			// sets the currentDisplayMode to a new DisplayMode of the correct size
			currentDisplayMode = new DisplayMode(sx, sy);
			// updates the display mode in use
			Display.setDisplayMode(currentDisplayMode);
			// creates a display
			Display.create();
			initOrtho();
		}
		catch(LWJGLException ex)
		{
			// if fails, prints an error message and exits
			System.err.println("ERROR: Could not create display");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Makes a new DisplayMode with a new x and y
	 * @param sx the width in pixels
	 * @param sy the height in pixels
	 */
	public static void setDisplayMode(int sx, int sy)
	{
		try 
		{
			// update the display mode 
			currentDisplayMode = new DisplayMode(sx, sy);
			Display.setDisplayMode(currentDisplayMode);
			initOrtho();
		} 
		catch (LWJGLException ex) 
		{
			// if fails, prints an error message and exits
			System.err.println("ERROR: Could not change display mode");
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Sets the orthographic projection matrix
	 */
	private static void initOrtho()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, currentDisplayMode.getWidth(), currentDisplayMode.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    	
		setClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
	}
	
	/**
	 * sets the clear color of the display
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * @param a Alpha
	 */
	public static void setClearColor(float r, float g, float b, float a)
	{
		glClearColor(r, g, b, a);
	}
	
	/**
	 * Draws whatever is in the buffer to the display, should be called once per frame
	 */
	public static void update()
	{
		Display.update();
	}
	
	/**
	 * checks if the user has requested a close of the window
	 * @return if the user has clicked the x of the window
	 */
	public static boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
	
	/**
	 * tells lwjgl to cap the frame rate of the window
	 * @param fps frame per second cap
	 */
	public static void capFps(int fps)
	{
		Display.sync(fps);
	}
	
	/**
	 * clears the color and depth buffers of the frame buffer, which clears the screen
	 */
	public static void clearScreen()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	/**
	 * closes the display, removes all resources from the GPU
	 */
	public static void destroy()
	{
		Display.destroy();
	}
}
