package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import utilities.RetryAnalyzer;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());

        // Reset retry count before every fresh test
        IRetryAnalyzer analyzer = result.getMethod().getRetryAnalyzer(result);
        if (analyzer instanceof RetryAnalyzer) {
            ((RetryAnalyzer) analyzer).reset();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());

        // Get driver from BaseTest and take screenshot
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;
        try {
			ScreenshotUtils.captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠ TEST SKIPPED: " + result.getName());
    }
}