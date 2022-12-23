package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_test {
	WebDriver driver;
	Properties prop;

	@BeforeClass
	public void intilizedriver() throws FileNotFoundException, IOException {

		prop = new Properties();
		prop.load(new FileInputStream(
		System.getProperty("user.dir") + "//src//test//java//package1//Browserfile.properties"));

		String browser = prop.getProperty("Browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions fo=new FirefoxOptions();
			fo.setBinary("C:\\Users\\subbu\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(fo);
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		
	}

/*	@BeforeMethod
	public void opensite() throws FileNotFoundException, IOException {
		driver = intilizedriver();
		driver.get(prop.getProperty("URL"));

		//return driver;
	}*/

/*	@AfterMethod
	public void tear_Down() {
		driver.close();
	}*/

}
