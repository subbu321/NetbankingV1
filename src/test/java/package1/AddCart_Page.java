package package1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCart_Page {
	WebDriver driver;
	public AddCart_Page(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void AddTo_Cart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h5")));
		List<WebElement> items = driver.findElements(By.xpath("//h5"));

		int i = 0;
		while (items.size() > i) {

			driver.findElements(By.cssSelector("button[class='btn w-10 rounded']")).get(i).click();
			Thread.sleep(2000);
			i++;
		}
	}
	public void cart_Page() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");
		Thread.sleep(2000);
		boolean checkout = driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']"))
				.isDisplayed();
		if (checkout) {
			WebElement out = driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", out);
		} else {
			System.out.println("No items in the cart");
		}
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button")));
		List<WebElement> countries = driver
				.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));

		countries.stream().filter(c -> c.getText().equalsIgnoreCase("india")).findFirst().ifPresent(WebElement::click);
	    driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
	     Thread.sleep(2000);
	    boolean mess = driver.findElement(By.cssSelector(".hero-primary")).isDisplayed();
	    if(mess) {
	    	driver.findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
	    }else
	    	System.out.println("place order issue,please check");
	}

}
