package package1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Abhi_Bus {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
	      WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	      driver.get("https://www.abhibus.com/");
	      
	      
	    WebElement from = driver.findElement(By.cssSelector("input#source"));
	     from.sendKeys("Hyd");
	     Thread.sleep(2000);
	     String enter = Keys.chord(Keys.RETURN);
	     from.sendKeys(enter);
	     WebElement To = driver.findElement(By.cssSelector("input#destination"));
	     To.sendKeys("Vija");
	     Thread.sleep(2000);
	     To.sendKeys(enter);
	      
	      driver.findElement(By.cssSelector("input#datepicker1")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ui-state-default ui-state-highlight']")));
	    
	      driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]")).click();
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='col-md-auto'])[2]")));

	      driver.findElement(By.xpath("(//div[@class='col-md-auto'])[2]")).click();
	      Thread.sleep(4000);
	      driver.findElement(By.xpath("//a[@id='1303418343']")).click();
	      Thread.sleep(4000);
	     // driver.findElement(By.xpath("//a[@id='O6-3ZZ']")).click();
	      
	     List<WebElement> seats = driver.findElements
	 (By.xpath("(//div[@class='seats'])[1]/ul/li[contains(@class,'sleeper available') and not(@class='noseat')]/a"));
	     
	     System.out.println(seats.size());
	      
	}

}
