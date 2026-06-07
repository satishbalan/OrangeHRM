package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;

@Listeners(listeners.TestListener.class)

public class LoginTest extends BaseTest
{		
	@Test
	public void loginTest() throws InterruptedException
	{   
		LoginPage lp = new LoginPage(driver);
		lp.login(ConfigReader.get("username"), ConfigReader.get("password"));
	}
	
} 
	
