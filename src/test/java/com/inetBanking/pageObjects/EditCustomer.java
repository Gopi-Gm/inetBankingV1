package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer
{

WebDriver ldriver;
	
	public  EditCustomer(WebDriver rdriver ) // we creted constructor edit customer
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how= How.XPATH, using="//a[normalize-space()='Edit Customer']")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(how= How.XPATH, using="//input[@name='cusid']")
	@CacheLookup
	WebElement txtCustomerid;
	
	@FindBy(how= How.XPATH, using="//input[@name='AccSubmit']")
	@CacheLookup
	WebElement buttonsubmit;
	
	@FindBy(how= How.XPATH, using="//input[@name='sub']")
	@CacheLookup
	WebElement editsubmit;
	
	
	
	
	public void clickEditCustomer()
	{
		lnkEditCustomer.click();
	}
	
	public void Customerid(String custid)
	{
		txtCustomerid.sendKeys(custid);
	}
	
	public void Submitbutton()
	{
		buttonsubmit.click();
	}
	
	public void Editsubmit()
	{
		editsubmit.click();
	}
	
}
