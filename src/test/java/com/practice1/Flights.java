package com.practice1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flights {

	WebDriver driver;

	void Open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	}

	void drop_Down() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@value='Departure City'])[1]")).click();
		driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul[1]/li[5]")).click();

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(3000);
		List<WebElement> cities = driver.findElements(By.xpath(
				"//div[@class='right1']//div[@class='search_options_menucontentbg']/div/table/tbody/tr[2]/td[@class='mapbg']//div[@class='search_options_menucontent']/div[1]/div/ul/li"));
		//// div[@class='right1']/child::div[2]//table/tbody/tr[2]/td[@class='mapbg']/child::div[3]//div[1]/div/ul/li
		
		 cities.stream().filter(c->c.getText().split(" ")[0].equalsIgnoreCase("jaipur")).forEach(c->c.click());
		
	/*	for (WebElement destination : cities) {
			String city = destination.getText().split(" ")[0];
			System.out.println(city);
			if (city.equalsIgnoreCase("Kochi")) {
				destination.click();
				System.out.println(city);
				break;

			}
		}*/

	}

	void select_Date() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		Thread.sleep(3000);
		
		

		while (true) {
			WebElement month = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]"));
			String mnth = month.getText().split(" ")[0];
			if (mnth.equalsIgnoreCase("February")) {
				break;
			} else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}
		String date = "21";
		List<WebElement> dates = driver.findElements(By.xpath(
				"(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td[@data-handler='selectDay'and not(@class=' ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled')]"));
	/*	for (WebElement date1 : dates) {
			String day = date1.getText();
			if (day.contains(date)) {
				date1.click();
				break;
			}

		}*/
		           
		dates.stream()
        .filter(element -> element.getText().contains(date))
        .findFirst().ifPresent(WebElement::click);

	}

	public static void main(String[] args) throws InterruptedException {

		Flights fl = new Flights();
		fl.Open_browser();
		//fl.drop_Down();
		fl.select_Date();

		
	}

}
