package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get("https://demo.guru99.com/v3/index.php");
		//driver.get(BaseURL);
		
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);  // object created for page object class
		lp.setUserName(username);
		logger.info("entred username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		logger.info("URL is Opened");
		
		
		if(driver.getTitle().equals("Welcome To Manager's Page of Guru99 Bank"))
		{
			Assert.assertTrue(false);
			logger.info("login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest" );
			Assert.assertTrue(true);
			logger.info("login test failed");
		}
	}
	

}
