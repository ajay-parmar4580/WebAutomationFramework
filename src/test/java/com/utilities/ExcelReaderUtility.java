package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public abstract class ExcelReaderUtility {
	
	public static Iterator<User> readLoginData(String fileName){
		File xlsxFile =new File(Paths.get(System.getProperty("user.dir"), "testData", "excelData", fileName).toString());
		//File xlsxFile = new File(System.getProperty("user.dir")+"//testData//excelData//"+fileName);
		XSSFWorkbook xssfWorkook;
		XSSFSheet xssfSheet; 
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		List<User> userList = null;
		User user;
		try {
			xssfWorkook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				userList = new ArrayList<User>();
				user = new User(emailAddressCell.getStringCellValue(),passwordCell.getStringCellValue());
				userList.add(user);
			}
			xssfWorkook.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
