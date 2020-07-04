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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateRegistration {
	
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
		
	
	@Test(dataProvider="getData")
	public void validateRgisterTest(String fName,String lName,String phone,String email,String add1,String city,String state,String pC,String country,String uName,String pass,String cPass) throws InterruptedException, IOException {
		
		
			
			driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
			driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lName);
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
			driver.findElement(By.xpath("//input[@name='userName']")).clear();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='address1']")).clear();
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(add1);
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
			driver.findElement(By.xpath("//input[@name='state']")).clear();
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
			driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(pC);
			//driver.findElement(By.xpath("//select[@name='country']")).clear();
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(country);
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(uName);
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(cPass);
			
			driver.findElement(By.xpath("//input[@name='register']")).click();
			
			
			String expText=uName;
			String actText=driver.findElement(By.xpath("//a/descendant::b")).getText();
			
		    boolean b=false;
		    
		    if(actText.contains(expText))
		    {
		    	b=true;
		    	
		    	
		    }
		    else
		    {
		    	b=false;
		    }
		    
		    Assert.assertTrue(b);
		    
		    
		  
			
			
			
			
			
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		FileInputStream f=new FileInputStream("src\\test\\resources\\testdata\\excels\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Row row=ws.getRow(0);
		
		System.out.println(row.getLastCellNum());
		
		Object[][] obj=new Object[ws.getLastRowNum()][row.getLastCellNum()];
		
		
		
		for(int i=0;i<=ws.getLastRowNum()-1;i++)
		{
			
			obj[i][0]=ws.getRow(i+1).getCell(0).getStringCellValue();
			obj[i][1]=ws.getRow(i+1).getCell(1).getStringCellValue();
			obj[i][2]=ws.getRow(i+1).getCell(2).getStringCellValue();
			obj[i][3]=ws.getRow(i+1).getCell(3).getStringCellValue();
			obj[i][4]=ws.getRow(i+1).getCell(4).getStringCellValue();
			obj[i][5]=ws.getRow(i+1).getCell(5).getStringCellValue();
			obj[i][6]=ws.getRow(i+1).getCell(6).getStringCellValue();
			obj[i][7]=ws.getRow(i+1).getCell(7).getStringCellValue();
			obj[i][8]=ws.getRow(i+1).getCell(8).getStringCellValue();
			obj[i][9]=ws.getRow(i+1).getCell(9).getStringCellValue();
			obj[i][10]=ws.getRow(i+1).getCell(10).getStringCellValue();
			obj[i][11]=ws.getRow(i+1).getCell(11).getStringCellValue();
			
			
		}
		
		return obj;
		
	}
		
		
	}
		
		
