package com.base.game;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import com.base.core.NetworkHelper;
import com.base.core.Resource;
import com.base.core.UnzipUtility;

public class AutoUpdate {
	public static final String updateURL =
			"https://raw.githubusercontent.com/thomaslauer/Block-Dude-res/master/VID.txt";
	
	
	public static final String masterURL = 
			"https://github.com/thomaslauer/Block-Dude-res/archive/master.zip";
	/**
	 * Checks if there is an update from the git repo. uses the version.txt file to check.
	 * If there is one, it downloads and replaces all the files in the res folder
	 * @return if an update is ready
	 */
	public static boolean hasUpdates()
	{
		try
		{
			NetworkHelper vidDownloader = new NetworkHelper(updateURL);
			String gitVid = vidDownloader.getString();
			
			String localVid = Resource.loadTextToString("res/VID.txt");
			
			System.out.println("Local version: " + localVid + ", remote: " + gitVid);
			if(gitVid.equals(localVid))
			{
				return false;
			}
		} catch(MalformedURLException ex)
		{
			System.err.println("Could not connect to GitHub, check URL");
		} catch (IOException e) {
			System.err.println("Could not connect to GitHub, check URL");
		}
		return true;
	}
	
	
	/**
	 * downloads an update to the res folder from github
	 */
	public static void getUpdate()
	{
		try {
			NetworkHelper downloader = new NetworkHelper(masterURL);
			downloader.saveToDisk("res.zip");
			
			Resource.delete(new File("res"));
			
			UnzipUtility uzu = new UnzipUtility();
			uzu.unzip("res.zip", "tempRes");
			Resource.copyFolder(new File("tempRes/Block-Dude-res-master"), new File("res"));
			
			Resource.delete(new File("tempRes"));
			Resource.delete(new File("res.zip"));
		} catch (IOException e) {
			System.out.println("ERROR: could not download from master");
			e.printStackTrace();
		}
	}
}
