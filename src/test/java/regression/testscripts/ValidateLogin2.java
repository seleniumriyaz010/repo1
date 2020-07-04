package regression.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

public class ValidateLogin2 extends Base{
	
	

	@BeforeMethod
	public void setUp() {

		
		initialization();
		

	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		quitBrowser();
	}
		
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String u,String p) throws InterruptedException {
		
		test=extent.createTest("validateLoginTest");
		System.out.println(u);
		System.out.println(p);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(u);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String expTitle="Find a Flight: Mercury Tours:";
		
		String actTitle=driver.getTitle();
		
		boolean b=actTitle.contains(expTitle)?true:false;
		
		
		Assert.assertTrue(b);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="qshore";
		obj[0][1]="qshore123";
		
		obj[1][0]="reyaz";
		obj[1][1]="reyaz123";
		
		return obj;
		
	}
		
		
	}
		
		
