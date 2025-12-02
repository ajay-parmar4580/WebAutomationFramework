package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.User;
import com.ui.pojo.UserData;
import com.utilities.CSVReaderUtility;
import com.utilities.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider(){
		Gson gson = new Gson();
		File userDataFile = new File(Paths.get(System.getProperty("user.dir"),"testData","jsonData","logindata.json").toString());
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(userDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		UserData data  = gson.fromJson(fileReader, UserData.class);
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user: data.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginTestCsvDataProvider() {
		return CSVReaderUtility.readLoginData("logindata.csv");
	}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginTestExcelDataProvider(){
		return ExcelReaderUtility.readLoginData("loginData.xlsx");
	}

}
