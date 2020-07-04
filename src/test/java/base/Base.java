package base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	public static WebDriver driver;
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	
	public static void initialization()
	{
		driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		date = date.replace(":", "-");
		
		System.out.println(date);
		
		String reportDirectory=System.getProperty("user.dir")+"\\reports\\";
		
		File path=new File(reportDirectory+date+".html");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Regression Test");
		
		reporter.config().setDocumentTitle("Regression Test Results");
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Reyaz Shaik");
		
		
		
	}
	
	
	public static void quitBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		
		extent.flush();
		
		driver.quit();
	}
	
	

}
