package regression.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailUsingProperties {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		
		driver = new ChromeDriver();

		driver.get("http://www.gmail.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);

		driver.quit();
	}
		
	
	@Test
	public void validateLoginTest() throws InterruptedException, IOException {
		
		FileInputStream f=new FileInputStream("GmailProperties.properties");
		
		Properties pr=new Properties();
		
		pr.load(f);
		
		

		driver.findElement(By.xpath(pr.getProperty("txt_email"))).sendKeys("selenium.riyaz009");
		
		driver.findElement(By.xpath(pr.getProperty("btn_emailnext"))).click();
		
        //Thread.sleep(3000);
        
		driver.findElement(By.xpath(pr.getProperty("txt_password"))).sendKeys("5434546gfgf");
		
		driver.findElement(By.xpath(pr.getProperty("btn_passnext"))).click();
		
		
	}
		
		
	}
		
		
