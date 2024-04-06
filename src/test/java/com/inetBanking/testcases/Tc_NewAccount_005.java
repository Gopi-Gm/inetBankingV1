package com.inetBanking.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewAccountPage;

public class Tc_NewAccount_005 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		NewAccountPage addac= new NewAccountPage(driver);
		
		logger.info("Adding Details");
		addac.clickAddNewAccount();
		addac.Customerid("34063");
		addac.selcAccountType("ACC Type");
		addac.InitialDeposit("50000");
		addac.AccSubmit();
		Thread.sleep(5000);
		addac.Continue(); // Account Generated Successfully!!!
		
		boolean result = driver.getPageSource().contains("Account Generated Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		} else {
			logger.info("testcase is failed");
			captureScreen(driver, "EditCustomer"); // Capture screenshot method
			Assert.assertTrue(false); 
		}
		
		
		
		
		

		
	}
	
}
