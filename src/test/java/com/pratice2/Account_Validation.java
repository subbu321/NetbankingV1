package com.pratice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Account_Validation {
	FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet Excelsheeet;

	@Test(dataProvider = "data_Supplier")
	public void login_Creditanlas(String UserName, String PassWord) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.cssSelector("input#userEmail")).sendKeys(UserName);

		driver.findElement(By.cssSelector("input#userPassword")).sendKeys(PassWord);
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Automation']")));
		boolean text = driver.findElement(By.xpath("//*[text()='Automation']")).isDisplayed();
		
			if (text == true) {
				setCellValue().setCellValue("pass");
			} else {
				setCellValue().setCellValue("false");
			}
		}
	

	public XSSFCell setCellValue() throws IOException {
		// creating a new cell in row and setting value to it
		XSSFCell cell = Excelsheeet.getRow(3).createCell(2);

		FileOutputStream outputStream = new FileOutputStream(
				"S:\\Javafolder\\Practice\\src\\test\\resources\\letshop.xlsx");
		workbook.write(outputStream);
		outputStream.close();
		return cell;
	}

	@DataProvider
	public Object[][] data_Supplier() throws IOException {
		try {
			fis = new FileInputStream("S:\\Javafolder\\Practice\\src\\test\\resources\\letshop.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Excelsheeet = workbook.getSheet("sheet1");
		int rows = Excelsheeet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int column = Excelsheeet.getRow(0).getLastCellNum();
		System.out.println(column);

		Object[][] data = new Object[rows - 1][column];
		for (int r = 0; r < rows - 1; r++) {
			for (int c = 0; c < column; c++) {
				DataFormatter dt = new DataFormatter();
				data[r][c] = Excelsheeet.getRow(r + 1).getCell(c);
				data[r][c] = dt.formatCellValue((Cell) data[r][c]);
			}

		}

		return data;
	}

	/*
	 * @DataProvider public Object[][] data() { HashMap<String,String> map=new
	 * HashMap<String,String>(); map.put("eamil", "maheshburra321@gmail.com");
	 * map.put("password","Teja@123"); return new Object[][] {{map}}; }
	 */

}
