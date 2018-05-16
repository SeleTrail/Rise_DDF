package com.rise.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rise.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test (dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("addcust"))).click();
		driver.findElement(By.xpath(OR.getProperty("fname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("pcode"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addcustbtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
	
		
	}

	@DataProvider
	public Object [][] getData()
	{
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object [rows-1][cols];
		
		for(int rowNum = 2; rowNum<= rows; rowNum++)
		{
			for(int colNum= 0; colNum<cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum,rowNum);
				
			}
		}
		return data;
	}
	
}
