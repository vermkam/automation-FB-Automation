package com.utility;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/*
 * This class has the common methods for all test classes
 * 
 */
public class browsersFactory {

	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
 @BeforeSuite
 public static ExtentReports setupSuite()
 {
	    String filename = getReportName();
		String directry = System.getProperty("user.dir")+ "/Reports/";
		new File(directry).mkdirs();
		String path = directry+filename;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Coder", "Facebook Automation");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		return extent;
}
	public static String getReportName()
	{
		Date d=new Date();
		String filename = "AutomationReport_" + "_"+ d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return filename;
	}

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "chromePath", "firefoxPath", "url" })
	public void setup(String browser, String chromePath, String firefoxPath, String url) {

           if (browser.equals("chrome")) {
        	ChromeOptions options = new ChromeOptions(); 
            options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void tearSuite(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{   String methodName = result.getMethod().getMethodName();
			String logText = "<b>Test Method " + result.getClass().getName() + " :: " + result.getMethod().getMethodName() + "Failed<b>";
		    Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.log(Status.FAIL,m);
			test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot.takeScreenShot(driver,methodName)).build());
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>Test Method " + result.getClass().getName() + " :: " + result.getMethod().getMethodName() + "Successful<b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot.takeScreenShot(driver,methodName)).build());
			test.log(Status.PASS,m);
		}
		else 
		{
			String logText = "<b>Test Method " + result.getClass().getName() + " :: " + result.getMethod().getMethodName() + "Skipped<b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.log(Status.SKIP,m);
		   test.skip(result.getThrowable());
		}
		extent.flush();
	}
	
}
