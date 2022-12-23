package com.pratice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.pratice2.Listeners.class)
public class Listens {
	WebDriver driver;

	@Test(priority = 0)
	public void open_Browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void close_Browser() throws InterruptedException {
	   Thread.sleep(1000);	
		driver.close();
	}

	@Test(priority = 1)
	public void Action_OnBrowser() throws Exception {
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("maheshburra321@gmail.com");

		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Teja@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		boolean text = driver.findElement(By.xpath("//h3[normalize-space()='Automation']")).isDisplayed();
	Assert.assertTrue(text);
	}

}
