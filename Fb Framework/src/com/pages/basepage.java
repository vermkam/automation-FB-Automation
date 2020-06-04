package com.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage {
	private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    
    public WebDriver driver;
    private WebDriverWait wait;
	
    public basepage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }
	
	protected void waitForElementToAppear(By Locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	protected void getElementAndClick(By Locator)
	{
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		element.click();
	}
	protected void getElementAndEnter(By Locator, String text)
	{
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		element.sendKeys(text);
	}
	protected void selectFromDropdown(By Locator,String text)
	{
		Select si = new Select(driver.findElement(Locator));
		si.selectByVisibleText(text);
	}
	protected void radioButton(By Locator,String Gender)
	{
		List<WebElement> radiobuttons = driver.findElements(Locator);
		for(WebElement radiobutton: radiobuttons)
		{
	        if(radiobutton.getText().equalsIgnoreCase(Gender))
		{
				radiobutton.click();
				break;
		}
		}
	}
	protected void gethandles()
	{
		//String parentGUID = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String handle:handles)
		driver.switchTo().window(handle);
	}
	protected void list(By Locator,String menuItem)
	{
		List<WebElement> list = driver.findElements(Locator);
		for(WebElement option: list)
		{
	        if(option.getText().equalsIgnoreCase(menuItem))
		{
				option.click();
				break;
		}
		}
	}
	public boolean isAlertPresent() {

	    boolean presentFlag = false;

	    try {

	        Alert alert = driver.switchTo().alert();
	        presentFlag = true;
	        alert.accept();
	      } 
	    catch (NoAlertPresentException ex) {
	        ex.printStackTrace();
	    }

	    return presentFlag;
	}
	protected void Enter()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	protected void hoverover(By locator)
	{
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		action.moveToElement(element).build().perform();
	}
	protected void scrollTillBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}
