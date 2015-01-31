package com.base.game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AutoUpdate {
	public static final String url =
			"https://raw.githubusercontent.com/thomaslauer/Block-Dude/master/VID.txt";
	
	/**
	 * Checks if there is an update from the git repo. uses the version.txt file to check.
	 * If there is one, it downloads and replaces all the files in the res folder
	 * @return if an update is ready
	 */
	public static boolean hasUpdates()
	{
		try
		{
			URL link = new URL(url);
			InputStream in = new BufferedInputStream(link.openStream());
			Scanner input = new Scanner(in);
			
			String gitCurrent = "";
			while(input.hasNext())
			{
				gitCurrent += input.nextLine();
			}	
		
			FileInputStream vidIn = new FileInputStream(new File("VID.txt"));
			Scanner vidScanner = new Scanner(vidIn);
			
			String localCurrent = "";
			while(vidScanner.hasNext())
			{
				localCurrent += vidScanner.nextLine();
			}	
			
			if(localCurrent.equals(gitCurrent))
			{
				System.out.println("Up to date!");
			}	
			input.close();
			vidScanner.close();
			return false;
		} catch(Exception ex)
		{
			System.err.println("ERROR: Could not update with GitHub");
		}
		return false;
	}
	
	
	/**
	 * downloads an update to the res folder from github
	 */
	public static void getUpdate()
	{
		
	}
}
