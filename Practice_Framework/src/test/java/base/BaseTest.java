package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {
	
public WebDriver driver;

@BeforeMethod
public void setup() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get(ConfigReader.get("url"));
	Thread.sleep(2000);

}
@AfterMethod
public void tearDown()
{
	if (driver != null) {
		driver.quit();
	}
}
}
