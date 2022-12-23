package com.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Insert_drivers {
	WebDriver driver;

	public void select_driver(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("drivers are not available");
		}
	}

	public void enter_Url(String URL) {
		driver.manage().window().maximize();
		driver.get(URL);
		Apsrtc_JourenyDetails jd = new Apsrtc_JourenyDetails(driver);
		jd.from_To();

		Select_Date sd = new Select_Date(driver);
		sd.to_Return_Date();

		Apsrtc_FilterOption option = new Apsrtc_FilterOption(driver);
		option.bus_Class();
		option.bus_PickUp();
		option.bus_DropLocation();
		try {
			option.select_Bp();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("error occured");
		}
	}

}
