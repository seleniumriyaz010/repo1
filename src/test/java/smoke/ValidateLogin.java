package smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateLogin {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();

	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);

		driver.quit();
	}
		
	
	@Test
	public void validateRgisterTest(String uName,String pass) throws InterruptedException {
		
		
		
		
	}
		
	
	
	
		
	}
		
		
