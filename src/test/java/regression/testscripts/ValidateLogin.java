package regression.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLogin {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);

		driver.quit();
	}
		
	
	@Test
	public void validateLoginTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("qshore");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qshore123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		
		//System.out.println(driver.findElement(By.xpath("(//font[contains(text(),'Flight')])[2]")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("(//font[contains(text(),'Flight')])[2]")).getText(), "Flight Details");
		
	}
		
		
	}
		
		
