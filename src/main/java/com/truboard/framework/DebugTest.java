package com.truboard.framework;

import java.io.File;

import com.truboard.utils.CommonUtils;

public class DebugTest {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\admin\\Downloads");
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }
	    String val = chosenFile.getPath();

	}

}
