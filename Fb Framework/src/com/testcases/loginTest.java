package com.testcases;

import java.io.FileInputStream;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.loginPage;
import com.utility.browsersFactory;


public class loginTest extends browsersFactory 
{
	static loginPage lp;
 @Test(priority = 0)
  public void loginToFacebook()
  {
	 test = extent.createTest("loginToFacebook");
	  try {
		      Properties prop = new Properties();
	          FileInputStream fp = new FileInputStream("C:\\Users\\Kamal\\eclipse-workspace\\Fb Framework\\src\\com\\utility\\config.properties");
	          prop.load(fp);
	          String usernm=prop.getProperty("username");
	          String password = prop.getProperty("password");
	          
			 lp = new loginPage(getDriver());
			 lp.enterCredentials(usernm,password);
			 lp.loginButtonClick();
			 lp.verifyTitle();
           }
	     catch(Exception e)
		 {
	         Assert.fail("Should not have thrown any exception" + e.getStackTrace());
	     }
		
  }
 @Test(priority=1)
 public void personalProfile()
 {
	 test = extent.createTest("personalProfile");
	 lp.profileClick();
	 lp.editDetailsClick();
	 lp.getHandles();
 }

}
