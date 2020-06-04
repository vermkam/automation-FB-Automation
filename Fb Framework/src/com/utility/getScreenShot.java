package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class getScreenShot {
	public static String takeScreenShot(WebDriver driver,String methodName)
	{
		String filename = getScreenshotName(methodName);
		String directry = System.getProperty("user.dir") + "/Screenshots/";
		new File(directry).mkdirs();
		String path = directry+filename;
		try {
			File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot,new File(path));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return path;
		}
	 public static String getScreenshotName(String methodName)
	 {
		Date d=new Date();
		String filename = methodName + "_"+ d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return filename;
		}
	}
