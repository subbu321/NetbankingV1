package com.practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Apache_File {
	private static XSSFWorkbook workbook = null;
	private static FileInputStream FIS = null;
@Test(dataProvider = "values")
	public void getdata(Map<String,String>table) {
	System.out.println("----------test started----------------------");
	System.out.println(table.get("custNmae"));
	System.out.println(table.get("Gender"));

	System.out.println(table.get("Date"));

	System.out.println(table.get("Adddress"));
System.out.println("------------test ended--------------------------");
}
	@DataProvider(name="values")
	public static  Object[][] data_Provider() {
		try {
			FIS = new FileInputStream("./src/test/resources/data.xlsx");
			workbook = new XSSFWorkbook(FIS);
			workbook.close();
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("book not found");
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("sheet2");
		int lastRowNum = sheet.getLastRowNum() ;
		System.out.println(lastRowNum);
	     int lastCellNum = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[lastRowNum][1];
	    
	    for (int i = 0; i < lastRowNum; i++) {
	    	Map<Object, Object> datamap=new HashMap<>();
	    	//System.out.println("outer loop: "+datamap);
	    	for (int j = 0; j < lastCellNum; j++) {
	        DataFormatter df=new DataFormatter();
	       	datamap.put(df.formatCellValue(sheet.getRow(0).getCell(j)), df.formatCellValue(sheet.getRow(i+1).getCell(j)));
	     			
	    	}
	    	obj[i][0] = datamap;
	    	     
	    }
	     System.out.println("outer loop exists: "+obj[2][0]);
	    return  obj; 
		  		  
	}
	
	/*public static void main(String[] args) {
		data_Provider();
	}*/

}
