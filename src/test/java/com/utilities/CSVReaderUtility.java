package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readLoginData(String fileName){
		
		File file = new File(Paths.get(System.getProperty("user.dir"), "testData", "csvData",fileName).toString());
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();//Skipping first row which contains column names
			
			userList = new ArrayList<User>();

			while((line = csvReader.readNext())!=null) {
				userData = new User(line[0],line[1]);
				userList.add(userData);
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
