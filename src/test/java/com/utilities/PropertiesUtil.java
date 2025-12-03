package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.constants.Env;

public abstract class PropertiesUtil {

	public static String readProperty(Env env,String keyName){
		//File propfile = new File(Paths.get(System.getProperty("user.dir"), "config",env+".properties").toString());
		File propfile = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		//File propfile = new File("./config/"+env+".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propfile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(keyName.toUpperCase());
	}
}
