package com.base.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 * This class helps with getting files from a network, we could 
 * at some point combine it with Resource
 * @author Thomas Lauer
 *
 */
public class NetworkHelper 
{
	private String urlString;
	
	private URL url;
	
	public NetworkHelper(String url) throws MalformedURLException
	{
		this.urlString = url;
		this.url = new URL(urlString);
	}
	
	public String getString() throws IOException
	{
		InputStream in = new BufferedInputStream(url.openStream());
		Scanner input = new Scanner(in);
		
		String string = "";
		while(input.hasNext())
		{
			string += input.nextLine();
		}
		
		input.close();
		return string;
	}
	
	public File saveToDisk(String endingFileName) throws IOException
	{
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(endingFileName);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		return new File(endingFileName);
	}
	
	public String toString()
	{
		return urlString;
	}
}
