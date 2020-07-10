package com.selenium.testscripts;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.util.TestUtil;
import com.selenium.util.Xls_Reader;

public class TS1 extends TestUtil{
	Xls_Reader xls=new Xls_Reader("D:\\ReddyWorkspace\\DataDriven\\src\\com\\selenium\\xls\\TestData.xlsx");
	@Test(dataProvider="getTC1_QuickjobSearchdata")
	public void TC1_QuickjobSearch(Hashtable<String,String> table){
		//System.out.println(table.get("Industry")+"--"+table.get("keywords")+"--"+table.get("Location")+"--"+table.get("Jobage")+"--"+table.get("Jobtype"));
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.jobserve.com/in/en/Job-Search/");
		driver.findElement(By.xpath("//*[@id='txtKey']")).sendKeys(table.get("keywords"));
		driver.findElement(By.xpath("//*[@id='txtLoc']")).sendKeys(table.get("Location"));
		new Select(driver.findElement(By.xpath("//*[@id='selAge']"))).selectByVisibleText(table.get("Jobage"));
		driver.findElement(By.xpath("//*[@id='btnSearch']")).click();
		
	}
	
	@DataProvider
	public Object [][] getTC1_QuickjobSearchdata(){
		return TestUtil.getData("TC1_QuickjobSearch", "Sheet1", xls);
	}

	

}
