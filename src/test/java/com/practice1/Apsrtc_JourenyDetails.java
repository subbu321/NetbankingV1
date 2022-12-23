package com.practice1;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resuableMethods.Wait;

public class Apsrtc_JourenyDetails extends Wait {
	WebDriver driver;
	
	
	public Apsrtc_JourenyDetails(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="fromPlaceName")WebElement fromplace;
	@FindBy(id="toPlaceName")WebElement toplace;
	
	public void from_To() {
		
		String click = Keys.chord(Keys.ENTER);
		
		fromplace.sendKeys("hyd");
		waitFor_WebelementFromPlace();
		fromplace.sendKeys(click);

		toplace.sendKeys("tade");
		waitFor_WebelementTodest();
		toplace.sendKeys(click);
	}

}
