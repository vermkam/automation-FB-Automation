package com.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage extends basepage{
	private static By loginEmail = By.xpath("//input[@name='email']");
	private static By loginPassword=By.xpath("//input[@name='pass']");
	private static By loginClick = By.xpath("//label[@id='loginbutton']");
	private static By profilePage =By.xpath("//span[@class='_1vp5']");
	private static By editDetails = By.xpath("//span[contains(text(),'Edit Details')]");
	private static By handle = By.xpath("//span[contains(text(),'Cancel')]");
	private static String expectedTitle="Facebook";
	 /** dropDown = By.xpath("//div[@id='logoutMenu']"); //private static By
	 * dropDown=By.xpath("//div[@id='userNavigationLabel']"); //private static By
	 * menuList = By.xpath("(//ul[@class='_54nf'])/li/a/span");
	 */
	

	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	public void enterCredentials(String Email,String Password)
	{
		getElementAndEnter(loginEmail,Email);
		getElementAndEnter(loginPassword,Password);
	}
	public void loginButtonClick()
	
	{
		getElementAndClick(loginClick);
		waitForElementToAppear(profilePage);
	}
	public void verifyTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	public void profileClick()
	{
		getElementAndClick(profilePage);
	}
	public void editDetailsClick()
	{
		getElementAndClick(editDetails);
		
	}
	public void getHandles()
	{
		gethandles();
		getElementAndClick(handle);
		
	}

}
