package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.browsersFactory;


public class failedTest extends browsersFactory {
  @Test
  public void failTest() 
  {
	  test = extent.createTest("failTest");
	  Assert.assertEquals("Code", "Logic");
  }
}
