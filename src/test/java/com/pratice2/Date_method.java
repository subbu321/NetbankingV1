package com.pratice2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Date_method {

	public static void main(String[] args) throws ParseException {
       FirefoxOptions options=new FirefoxOptions();
       options.setBinary("C:\\Users\\subbu\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
      
       WebDriverManager.firefoxdriver().setup();
       WebDriver driver=new FirefoxDriver(options);
       
       driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
      
       //validating date user input
         String date="29-feb-2024";
         SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
         sdf.setLenient(false); //user given date is valid or not we use setlenient        
         Date formateddate = sdf.parse(date);  
       
         Calendar calendar= Calendar.getInstance();
         
		 calendar.setTime(formateddate);
         
		 int userdate =calendar.get(Calendar.DAY_OF_MONTH);
         int usermonth=calendar.get(Calendar.MONTH);
         int useryear=calendar.get(Calendar.YEAR);

        driver.findElement(By.id("second_date_picker")).click();
        String actualdate= driver.findElement(By.cssSelector("div[class='ui-datepicker-title']")).getText();
        calendar.setTime(new SimpleDateFormat("MMM yyy").parse(actualdate));
        int actualmonth = calendar.get(Calendar.MONTH);
       int actualyear = calendar.get(Calendar.YEAR);
      
      while(usermonth>actualmonth||useryear>actualyear) {
    	   driver.findElement(By.xpath("//a[@title='Next']")).click();
    	   actualdate= driver.findElement(By.cssSelector("div[class='ui-datepicker-title']")).getText();
    	   calendar.setTime(new SimpleDateFormat("MMM yyy").parse(actualdate));
           actualmonth=calendar.get(Calendar.MONTH);
          actualyear=calendar.get(Calendar.YEAR);
          
       }
      List<WebElement> dat = driver.findElements
    		  (By.cssSelector("table[class='ui-datepicker-calendar'] tbody>tr td:not([class*='ui-datepicker-other-month'])")); 
       
      dat.stream().filter(f->f.getText().equals(String.valueOf(userdate)))
        .findFirst().ifPresent(WebElement::click);
       
       
       //driver.findElement(By.)
       
	}

}
