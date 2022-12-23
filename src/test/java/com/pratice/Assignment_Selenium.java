package com.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_Selenium  {
	
   WebDriver driver;
	private static String parentwindow = null;
	
	public Assignment_Selenium(WebDriver driver){
		this.driver=driver;
	}
	

	void open_Site() {

		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
	}

	void child_Window() {

		Iterator<String> iterator = driver.getWindowHandles().iterator();
		 parentwindow = iterator.next();
		System.out.println("parent:" + parentwindow);
		String childwindow = iterator.next();
		System.out.println("child: " + childwindow);
		String name = driver.switchTo().window(childwindow).getTitle();
		System.out.println(name);
	}

	void page_Size() {
		WebElement pagenum = driver.findElement(By.id("page-menu"));
		Select se = new Select(pagenum);
		se.selectByIndex(1);
	}

	void sorting_Tabling() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));

		
		ArrayList<String> templist = new ArrayList<String>();
		ArrayList<String> originallist = new ArrayList<String>();
		for (WebElement row : rows) {
			originallist.add(row.getText());
			templist.add(row.getText());
		}

		Collections.sort(templist);
		Assert.assertEquals(templist, originallist);
		if (originallist.equals(templist)) {
			System.out.println(originallist);
		} else {
			driver.findElement(By.xpath("//table[@class='table table-bordered']/thead/tr/th[1]")).click();
		}
		driver.switchTo().window(parentwindow);
	}

	
}
