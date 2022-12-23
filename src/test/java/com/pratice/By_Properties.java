package com.pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class By_Properties {
	public Properties prop;
	public WebDriver driver;

	public WebDriver data_Selection() throws IOException  {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
	    System.getProperty("user.dir") + "//src//main//java//resuableMethods//data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");

		switch (browsername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("browser not mentioned");
		}
		return driver;

	}
	void goTo() {
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

}
