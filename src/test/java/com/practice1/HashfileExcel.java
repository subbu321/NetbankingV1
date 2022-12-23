package com.practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashfileExcel {
	private static XSSFWorkbook workbook = null;
	private static FileInputStream FIS = null;

	public static void main(String[] args) {
		try {
			FIS = new FileInputStream("./src/test/resources/data.xlsx");
			workbook = new XSSFWorkbook(FIS);
		} catch (FileNotFoundException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("book not found");
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum() ;
		int column = sheet.getRow(0).getLastCellNum();
		HashMap<String, String>data=new HashMap<>();
		
		for(int r=0; r<lastRowNum; r++) {
			
			System.out.println("outer loop: "+data);
			for(int j=0; j<column; j++) {
			 String key = sheet.getRow(0).getCell(j).getStringCellValue();
			 String value = sheet.getRow(r+1).getCell(j).getStringCellValue();
			 data.put(key, value);
			
			}
			
			System.out.println("innerloop: "+data);
			
			}
       // System.out.println("main area:" +data);
       for(Entry<String, String> entry:data.entrySet()) {
        	System.out.println(entry.getKey()+ " "+entry.getValue());
        }
	}

}
