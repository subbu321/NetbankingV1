package package1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resuableMethods.Wait;

public class Academy_Register extends Wait {
	WebDriver driver;

	/*
	 * we need to get driver life from object,which is created during initializing
	 * the web driver that's why created constructor. assign to global to access
	 * methods from driver.
	 */
	// initializing
	Academy_Register(WebDriver driver) {
		super(driver);// for giving life from child to parent constructor to access driver methods.we
						// use super keyword
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// for page object model we need to create page factory for driver
	}

	@FindBy(css = ".text-reset")
	WebElement registerlink;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(css = "#userMobile")
	WebElement phone;

	@FindBy(xpath = "//div[@class='row mb-2']//select")
	WebElement occupation;
		
	@FindBy(css = "div[class='form-group col-md-6']>label >span")
	List<WebElement> gender;
	
	public void register_Page() {
		registerlink.click();
	}

	public void details(String name, String last, String mail, String num,String value, String select) {
		firstName.sendKeys(name);
		lastname.sendKeys(last);
		email.sendKeys(mail);
		phone.sendKeys(num);
		Select se=new Select(occupation);
		se.selectByVisibleText(value);
		gender.stream().filter(f->f.getText().equalsIgnoreCase(select)).findFirst().ifPresent(WebElement::click);

	}

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "confirmPassword")
	WebElement confirm;

	@FindBy(xpath = "//div[contains(text(),'Password and Confirm')]")
	WebElement mesg;

	@FindBy(css = ".col-md-1")
	WebElement age;

	public void passwords(String pass, String cpass) {

		password.sendKeys(pass);
		confirm.sendKeys(cpass);
		age.click();
		/*confirm.sendKeys(Keys.ENTER);
		String display = mesg.getText();*/

		
	}

}
