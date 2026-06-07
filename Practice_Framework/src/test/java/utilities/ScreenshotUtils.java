package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
public static void captureScreenshot(WebDriver driver, String testName) throws IOException
{
	if (driver==null) {
		System.out.println("driver is null, Screenshot not captured");
		return;
	}
	String path = "./test-output/Screenshots/";
	File dir = new File(path);
	if(!dir.exists()) {
		dir.mkdirs();
	}
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./test-output/Screenshots/" + testName + ".png");
	FileUtils.copyFile(src, dest);
}
}
