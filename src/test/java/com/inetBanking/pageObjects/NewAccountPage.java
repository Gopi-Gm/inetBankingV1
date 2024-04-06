package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage 
{

WebDriver ldriver;
	
	public  NewAccountPage(WebDriver rdriver ) // we creted constructor
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=  How.CSS, using="a[href='addAccount.php']")
	@CacheLookup
	WebElement lnkNewAccountPage;
	
	@FindBy(how=  How.XPATH, using="//input[@name='cusid']")
	@CacheLookup
	WebElement txtCustomerid;
	
	@FindBy(how=  How.XPATH, using="//select[@name='selaccount']")
	@CacheLookup
	WebElement AccountType;
	
	@FindBy(how=  How.XPATH, using="//input[@name='inideposit']")
	@CacheLookup
	WebElement txtInitialDeposit;
	
	@FindBy(how=  How.XPATH, using="//input[@name='button2']")
	@CacheLookup
	WebElement SubButton;
	
	// After Submit
	@FindBy(how=  How.LINK_TEXT, using="Continue")
	@CacheLookup
	WebElement Continue;
	
	
	public void clickAddNewAccount() 
	{
		lnkNewAccountPage.click();	
	}
	
	public void Customerid(String Custid ) 
	{
		txtCustomerid.sendKeys(Custid);	
	}
	
	public void selcAccountType(String AccType ) 
	{
		Select Account= new Select(AccountType);
		Account.selectByVisibleText("Current");
		
	}
	
	public void InitialDeposit(String IniDep ) 
	{
		txtInitialDeposit.sendKeys(IniDep);	
	}
	
	public void AccSubmit() 
	{
		SubButton.click();	
	}
	
	public void Continue () 
	{
		Continue.click();	
	}
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
}
