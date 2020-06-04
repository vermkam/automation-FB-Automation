package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signup extends basepage {
	private static By firstname = By.xpath("//input[@name='firstname']");
	private static By lastname = By.xpath("//input[@name='lastname']");
	private static By email = By.xpath("//input[@name='reg_email__']");
	private static By reEnterEmail = By.xpath("//input[@name='reg_email_confirmation__']");
	private static By password = By.xpath("//input[@name='reg_passwd__']");
	private static By month = By.xpath("//select[@id='month']");
	private static By day = By.xpath("//select[@id='day']");
	private static By year = By.xpath("//select[@id='year']");
	private static By gender = By.xpath("(//input[@name='sex'])/following-sibling::label");
	private static By SignUp = By.xpath("(//button[contains(text(),'Sign Up')])[1]");
	public signup(WebDriver driver) 
	{
		super(driver);
		
    }
	public void EnterText(String FirstName,String LastName,String Email,String confirmEmail,String Password)
	{
		
		getElementAndEnter(firstname,FirstName);
		getElementAndEnter(lastname,LastName);
		getElementAndEnter(email,Email); 
		getElementAndEnter(reEnterEmail,confirmEmail);
		getElementAndEnter(password,Password);
		 
	}
	public void SelectOption(String Month,String Day,String Year)
	{
		selectFromDropdown(month,Month);
		selectFromDropdown(day,Day);
		selectFromDropdown(year,Year);
	}

	public void radioButtonSelect(String Gender) 
	{ 
		radioButton(gender,Gender); 
	}
	 
	public void pause() throws InterruptedException 
	{
		Thread.sleep(1000);
	}
	public void signUpClick()
	{
		getElementAndClick(SignUp);
	}
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
}
