package package1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login_From extends Base_test {
	@Test
	public void main_Page() throws InterruptedException {

		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("Gmail"));
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("input[type='submit']")).click();
			
	    
	 
	}
	

}
