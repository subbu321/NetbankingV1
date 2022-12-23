package com.practice1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resuableMethods.Wait;

public class Apsrtc_FilterOption extends Wait {
	WebDriver driver;

	public Apsrtc_FilterOption(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span#BtFid")
	WebElement acornonac;
	@FindBy(xpath = "(//div[@class='selectOptions'])[1]/ul/li")
	List<WebElement> clas;

	public void bus_Class() {
		waitFor_PageLoad();
		acornonac.click();
		// driver.findElement(By.cssSelector("span#BtFid")).click();
		// List<WebElement> clas =
		// driver.findElements(By.xpath("(//div[@class='selectOptions'])[1]/ul/li"));

		clas.stream().filter(ac -> ac.getText().equalsIgnoreCase("NON A/C CLASS")).findFirst()
				.ifPresent(WebElement::click);
	}

	@FindBy(css = "span#BpFid")
	WebElement pickup;
	@FindBy(xpath = "(//div[@class='selectOptions'])[2]/ul/li")
	List<WebElement> boarding;

	public void bus_PickUp() {
		pickup.click();
		
		boarding.stream().filter(bp -> bp.getText().equalsIgnoreCase("DILSUKHNAGAR")).findAny()
				.ifPresent(WebElement::click);
	}

	@FindBy(css = "span#DpFid")
	WebElement loca;
	@FindBy(xpath = "(//div[@class='selectOptions'])[3]/ul/li")
	List<WebElement> droppingpoint;
	@FindBy(xpath = "//div[@class='col5']//input[@id='SrvcSelectBtnForward6']")
	WebElement seats;

	public void bus_DropLocation() {
		loca.click();
		droppingpoint.stream().filter(dp -> dp.getText().equalsIgnoreCase("TADEPALLI GUDEM")).findFirst()
				.ifPresent(WebElement::click);
		
		seats.click();
	}

	@FindBy(id = "ForwardBoardId")
	WebElement Bp;
	@FindBy(css = "input#fwLtBtn")
	WebElement layout;
	public void select_Bp() throws InterruptedException {
		waitFor_display();
		Select se = new Select(Bp);
		se.selectByIndex(3);
		layout.click();
		Thread.sleep(3000);
		for(int i=1; i<=4; i++) {
			WebElement selectseat = driver.findElement(By.xpath("//li[@id='Forward"+i+"']"));
			selectseat.click();
		    }
	}

}
