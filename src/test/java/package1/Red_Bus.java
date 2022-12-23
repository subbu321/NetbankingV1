package package1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Red_Bus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.redbus.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='sc-jTzLTM bfMZDh']")).click();

		WebElement input = driver.findElement(By.cssSelector("input#src"));

		input.sendKeys("hyd");
		Thread.sleep(2000);
		List<WebElement> areas = driver.findElements(By.cssSelector("div[class='autoFill autosuggest-ul rdc-src']>li>div>li"));
		/*  for(WebElement area:areas) {
    	String name = area.getText().split(",")[0];
    	if(name.equalsIgnoreCase("Bhel")) {
    		area.click();
    		break;
    	}
    }*/

		areas.stream().filter(Area->Area.getText().split(",")[0].equalsIgnoreCase("Bhel"))
		.findFirst().ifPresent(WebElement::click);


		driver.findElement(By.cssSelector("input#dest")).sendKeys("vija");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='mainelm selected-hover']>li")));
		List<WebElement> destareas = driver.findElements(By.cssSelector("div[class='mainelm selected-hover']>li"));

		destareas.stream().filter(dest->dest.getText().split(",")[0].equalsIgnoreCase("Old RTC Bus Stand")).findFirst()
		.ifPresent(WebElement::click);


		driver.findElement(By.id("date-box")).click();
		//div[@class='DatePicker__DoubleCalendar-sc-1x9sb82-2 dwWaPy']//div[1]//span[1]//span[6]//div[2]//span[1]
		//driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 fxWHuy']")).click(); 
		driver.findElement
(By.xpath("//div[@class='DatePicker__DoubleCalendar-sc-1x9sb82-2 dwWaPy']//div[1]//span[1]//span[6]//div[2]//span[1]")).click();  


		driver.findElement(By.id("search_butn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-section")));

		driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[1]")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//li[@class='fl disPrice price-selected']")).click();
		Thread.sleep(2000);
		WebElement selectseat = driver.findElement(By.xpath("//canvas[@data-type='upper']"));

		int xcentre = selectseat.getLocation().getX();
	int ycentre = selectseat.getLocation().getY();
		/*Dimension lowerdeck = selectseat.getSize();
		System.out.println("Height: "+lowerdeck.getHeight());
		System.out.println("width: "+lowerdeck.getWidth());*/
	System.out.println("x-axis: "+xcentre);
	System.out.println("y-axis: "+ycentre);

		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(selectseat).moveByOffset(-74,-74).click().build().perform(); 


	}

}
