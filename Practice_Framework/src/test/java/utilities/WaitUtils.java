package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	WebDriverWait wait;
	WebDriver driver;
	
	public WaitUtils(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	}
public void waitForClickability(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForVisibility(WebElement element) {
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
