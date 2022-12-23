package com.pratice2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Browser {
	public static WebDriver driver;

	public void initilize_Browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}

public class Practice extends Browser {

	public void open_Browser(WebDriver driver) {
		driver.get("https://www.google.com/");
	}

	public void enter_Search(WebDriver driver, String search, String val) throws InterruptedException {
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys(search);
		Thread.sleep(2000);
		List<WebElement> values = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		values.stream().filter(ac -> ac.getText().contains(val)).findFirst().ifPresent(WebElement::click);

	}

	public static void main(String[] args) throws InterruptedException {

		Practice p = new Practice();
		p.initilize_Browser();
		p.open_Browser(driver);
		p.enter_Search(driver, "cr", "Crushed");
	}

}
