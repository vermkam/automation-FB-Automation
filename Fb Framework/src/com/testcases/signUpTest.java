package com.testcases;


import java.util.ArrayList;
import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pages.signup;
import com.utility.TestUtil;
import com.utility.browsersFactory;

public class signUpTest extends browsersFactory
{
	
	
@DataProvider
public Iterator<Object[]> getData() throws Exception
{
	
    ArrayList<Object[]> testval = TestUtil.getExcelData();
	return testval.iterator();
}
@Test(dataProvider = "getData")
public void signUpPageTest(String Fname,String Lname,String Email,String ConfirmEmail,String Password,String Month,String Day,String Year,String gender)
{
	test = extent.createTest("signUpPageTest");
	 try {
		 signup sp = new signup(driver);
		 sp.EnterText(Fname, Lname,Email,ConfirmEmail,Password);
		 sp.SelectOption(Month,Day,Year);
	     sp.radioButtonSelect(gender);
		 sp.pause();
		 sp.signUpClick();
		 sp.refreshPage();
		 
        }
     catch(Exception e)
	 {
         Assert.fail("Should not have thrown any exception" + e.getStackTrace());
     }
	

}
}
 
