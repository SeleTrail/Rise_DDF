package com.rise.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rise.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		
		log.debug("Inside Login Test");
		driver.findElement(By.xpath(OR.getProperty("bmbtn"))).click();
		log.debug("Navigated to Bank Manager Page");
		Thread.sleep(3000); //Explicit wait for a while
		log.debug(" Login successful");
		Reporter.log(" Login successfully executed");
		
		//comment
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addcust"))));
		
	}

}
