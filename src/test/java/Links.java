import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Links {
	public static HttpURLConnection connection=null;
	public static int responsecode;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link:links) {
			String www = link.getAttribute("href");
			
		  
		try {
			URL url=new URL(www);
		   connection = (HttpURLConnection) url.openConnection();
		   		  
		   responsecode=connection.getResponseCode();
			
		} catch (IOException e) {
			System.out.println("link not found");
			e.printStackTrace();
		}
		//System.out.println(responsecode);
		}
		if(responsecode>=200) {
			System.out.println("link is working condition");
		}else if(responsecode>200&&responsecode<=500) {
		   System.out.println("link is not working condition");
		}
	}

}
