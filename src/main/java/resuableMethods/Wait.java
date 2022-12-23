package resuableMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*this parent class is reusable in every class that's why taking driver life from child class. we use 'super' keyword
 * to get driver life here */
public class Wait {
	WebDriver driver;

	public Wait(WebDriver driver) {
		this.driver = driver;

	}

	public void waitFor_WebelementFromPlace() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#ui-id-1")));
	}

	public void waitFor_WebelementTodest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#ui-id-2")));

	}

	public void waitFor_PageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#BtFid")));
	}

	public void waitFor_display() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ForwardBoardId")));
	}
}
