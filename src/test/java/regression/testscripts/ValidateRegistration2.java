package regression.testscripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateRegistration2 {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();

	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);

		driver.quit();
	}
		
	
	@Test
	public void validateRgisterTest() throws InterruptedException, IOException {
		
		
		FileInputStream f=new FileInputStream("src\\test\\resources\\testdata\\excels\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> rows=ws.iterator();
		
		rows.next();
		
		Row r=null;
		
		while(rows.hasNext())
		{
			
			r=rows.next();
			
			driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(r.getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='userName']")).clear();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='address1']")).clear();
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(r.getCell(5).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='state']")).clear();
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(r.getCell(6).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(r.getCell(7).getStringCellValue());
			//driver.findElement(By.xpath("//select[@name='country']")).clear();
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(r.getCell(8).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(r.getCell(9).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(r.getCell(10).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(r.getCell(11).getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='register']")).click();
			
			
			String expText=r.getCell(9).getStringCellValue();
			
			String actText=driver.findElement(By.xpath("//a/descendant::b")).getText();
			
			if(actText.contains(expText))
			{
				
				System.out.println("Registration is Successful");
				
				r.createCell(12).setCellValue("Passed");
			}
			
			else
			{
				System.out.println("Registration is not Successful");
				
				r.createCell(12).setCellValue("Failed");
				
			}
			
			
			driver.navigate().back();
			
			
			
			FileOutputStream f1=new FileOutputStream("src\\test\\resources\\testdata\\excels\\registration.xlsx");
			
			wb.write(f1);
			
			f1.close();
		}
		
		
	}
	
	
		
		
	}
		
		
