
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Path_Usa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		/*
		 * WebElement checkbox = driver.findElement(By.id("checkBoxOption2"));
		 * checkbox.click();
		 * 
		 * String option = checkbox.getAttribute("value");
		 * 
		 * driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click(
		 * );
		 * 
		 * List<WebElement> values =
		 * driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option")
		 * );
		 * 
		 * values.stream().filter(f->f.getText().equalsIgnoreCase(option)).forEach(
		 * WebElement::click);
		 * 
		 * 
		 * 
		 * WebElement element=driver.findElement(By.xpath("//input[@id='name']"));
		 * 
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].value='option2';",
		 * element);
		 * 
		 * driver.findElement(By.id("alertbtn")).click();
		 * 
		 * String str=driver.switchTo().alert().getText();
		 * 
		 * if( str.subSequence(6,13).equals(option)) { System.out.println(true); }else {
		 * System.out.println(false); }
		 */

		driver.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();

		
		String month = driver.findElement(By.xpath("//div[@class='flatpickr-month']//span[@class='cur-month']"))
				.getText();
	      	String year = driver.findElement(By.xpath("//input[@min='2022']")).getAttribute("min");
	      	System.out.println(year);
		
	/*	while (!month.equalsIgnoreCase("august")) {
                System.out.println(month);
			driver.findElement(By.cssSelector("div[class='flatpickr-month'] span[class='flatpickr-next-month']"))
					.click();
             Thread.sleep(1000);
			month = driver.findElement(By.xpath("//div[@class='flatpickr-month']//span[@class='cur-month']")).getText();

		}*/

		/*
		 * List<WebElement> dates = driver.findElements(By.
		 * xpath("//span[not(@class='flatpickr-day disabled')and(@class='flatpickr-day ')]"
		 * ));
		 * 
		 * dates.stream().filter(f->f.getText().equalsIgnoreCase("21")).forEach(
		 * WebElement::click);
		 * 
		 * /* for(WebElement date:dates) { if(date.getText().equalsIgnoreCase("22")) {
		 * date.click(); break; }
		 * 
		 * }
		 */

	}

}
