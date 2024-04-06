package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();

		AddCustomerPage addcust = new AddCustomerPage(driver);

		logger.info("providing customer details......");
		addcust.clickAddNewCustomer();
		addcust.custName("Gopi");
		addcust.custgender("male");
		addcust.custdob("13", "03", "2002");
		addcust.custaddress("india");
		addcust.custcity("hosur");
		addcust.custstate("tamilnadu");
		addcust.custpinno("632403");
		addcust.custtelephoneno("8960542721");

		String email = randomestring() + "@gamil.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(5000);

		logger.info("validation is strated");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		} else {
			logger.info("testcase is failed");
			captureScreen(driver, "addNewCustomer"); // Capture screenshot method
			Assert.assertTrue(false);
		}

	}
	// user defined method
	/*
	 * public String randomstring() { String generatedString=
	 * RandomStringUtils.randomAlphabetic(8); return (generatedString);
	 * 
	 * }
	 * 
	 * public static String randomeNum() { String generatedString2 =
	 * RandomStringUtils.randomNumeric(4); return (generatedString2); }
	 */

}
