package com.pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intitate_browser {
	
	public static WebDriver driver =null;
	
	
	
	public void open_Browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	void quit_Browser() {
		driver.quit();
	}
	static public void main(String[] args) {
		
		Intitate_browser bro=new Intitate_browser();
		bro.open_Browser();
		Assignment_Selenium start = new Assignment_Selenium(driver);
		
		start.open_Site();
		start.child_Window();
		// start.quit_Browser();
		start.page_Size();
		start.sorting_Tabling();
		

	}


}
