package com.practice1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Select_Date {
	WebDriver driver;
	public Select_Date(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtJourneyDate")WebElement to_date;
	@FindBy(id="txtReturnJourneyDate")WebElement Return_date;
	@FindBy(id="searchBtn")WebElement check;
	public void to_Return_Date() {
		to_date.click();
		//driver.findElement(By.id("txtJourneyDate")).click();
		select_Month(driver, "november", "2022");
		select_Date(driver,"30");
		Return_date.click();
		//driver.findElement(By.id("txtReturnJourneyDate")).click();
		select_Month(driver, "december", "2022");
		select_Date(driver, "14");
		//Loginbutton
	        //driver.findElement(By.id("searchBtn")).click();
		check.click();
	}
	
	
	public void select_Month(WebDriver driver, String mnth, String ye) {
		// selection month
		
		WebElement month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
		
		WebElement year = driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]"));
	
		if (month.getText().equalsIgnoreCase(mnth) && year.getText().equalsIgnoreCase(ye)) {
			System.out.println(month.getText() + " " + year.getText() + " ");
		} else {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		}
	}
	
	public static void select_Date(WebDriver driver, String dt) {
		// selection date
		List<WebElement> dates = driver.findElements(
				By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td[@data-handler='selectDay']"));
		System.out.println(dates.size());
		dates.stream().filter(date -> date.getText().equalsIgnoreCase(dt)).findFirst().ifPresent(WebElement::click);

	}
}
