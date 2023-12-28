package com.mkautomation.util;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigurationManager configFileReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigurationManager getConfigReader() {
		 return (configFileReader == null) ? new ConfigurationManager() : configFileReader;
	 }
}
