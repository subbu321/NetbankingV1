package com.pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apache_iterator {
	private static FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;

	public static void main(String[] args) {
		try {
			fis = new FileInputStream("./src/test/resources/Data1.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int sheet = workbook.getNumberOfSheets();// numbers of sheets will get from a excelsheet
        //for sheet selection in excel workbook
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet1 = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet1.iterator();// sheet contains total rows
				Row row = rows.next();

				Iterator<Cell> cells = row.cellIterator();// rows contains total rows
				int k = 0;
				int column = 0;
				// Capturing the based on the headings in excel sheet
				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// once column identified scan for test case id row
				// After identifying heading we need to capture particular data in a particular row
				
				while (rows.hasNext()) {
					Row entire_row = rows.next();
					if (entire_row.getCell(column).getStringCellValue().equalsIgnoreCase("ValidData")) {
						Iterator<Cell> data_cell = entire_row.cellIterator();
						while (data_cell.hasNext()) {
							String values = data_cell.next().getStringCellValue();
							System.out.println(values);
						}

					}
				}
			}
		}

	}

}
