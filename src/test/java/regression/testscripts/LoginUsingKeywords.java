package regression.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import keyword.LoginKeywords;

public class LoginUsingKeywords {
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		FileInputStream f1=new FileInputStream("GmailProperties.properties");
		
		Properties pr=new Properties();
		
		pr.load(f1);
		
		FileInputStream f=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginKeywords.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> rows=ws.iterator();
		
		rows.next();
		
		LoginKeywords keys=new LoginKeywords();
		
		
		
		while(rows.hasNext())
		{
			String action=rows.next().getCell(3).getStringCellValue();
			
			if(action.equals("launchBrowser"))
					{
				      keys.launchBrowser();   
				
					}
			else if(action.equals("navigate"))
			{
				keys.navigate();
			}
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(pr.getProperty("txt_email"));
			}
			else if(action.equals("clickNext"))
			{
				keys.clickNext(pr.getProperty("btn_emailnext"));
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword(pr.getProperty("txt_password"));
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(pr.getProperty("btn_passnext"));
			}
		}
		
		
	}

}
