package com.pipeline.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties properties;
	File file;
	FileInputStream fis;
	private String lfilePath;
	private String lfileName;

	public ConfigReader(String filePath, String fileName) {
		this.lfilePath = filePath;
		this.lfileName = fileName;
	}

	public String fetch(String key) {
		properties = read(lfileName);
		String value = properties.get(key).toString();
		return value;
	}

	private Properties read(String fileName) {
		properties = new Properties();
		file = new File(lfilePath + lfileName);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}