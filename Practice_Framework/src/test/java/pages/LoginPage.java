package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

public class LoginPage {
	WebDriver driver;
	WaitUtils waitUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waitUtils= new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;
	
	
	public void login(String user, String pass) throws InterruptedException
	{
		waitUtils.waitForVisibility(username);
		username.sendKeys(user);
	
		waitUtils.waitForVisibility(password);
		password.sendKeys(pass);

		waitUtils.waitForClickability(LoginBtn);
		LoginBtn.click(); 
	
	}
	}
	


