package com.base.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Window {
	// current display mode
	public static DisplayMode currentDisplayMode;
	
	// creates a window with the given dimensions
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
	
	// changes the size of the window
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
	
	// method will set up orthographic 
	private static void initOrtho()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, currentDisplayMode.getWidth(), currentDisplayMode.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	// updates the display and pushes all drawing to screen
	public static void update()
	{
		Display.update();
	}
	
	// checks if a close has been requested
	public static boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
}
