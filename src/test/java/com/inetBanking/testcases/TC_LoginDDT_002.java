package com.inetBanking.testcases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			Thread.sleep(5000);
			lp.clickLogout();
			driver.switchTo().alert().accept();// Close the logout alert
		}
		
	}
	
	public boolean isAlertpresent() // user defind method craeted to check alert present are not, 
	{
		try	{		
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
	}
	
	
	@DataProvider( name="LoginData")
     String[][]getData() throws IOException
	{
	
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginDetails.xlsx"; // This is Excel path
		int rownum= XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
    String logindata[][]=new String[rownum][colcount]; // here we created 2 dimensional array
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
