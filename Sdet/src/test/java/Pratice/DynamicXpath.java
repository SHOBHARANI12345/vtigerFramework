package Pratice;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.propertyUtility;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {
		
		Date date=new Date();
		String[] d=date.toString().split(" ");
        
		String day=d[0];
		String month=d[1];
		
		String date1=d[2];
		String year=d[5];
		
		String TravelDate = day+" "+month+" "+date1+" "+year;
		System.out.println(TravelDate);
		
		  String Key="webdriver.chrome.driver";
			String value="D:\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(Key, value);
			


			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			propertyUtility plib = new propertyUtility();
		   Java_utility jlib = new Java_utility();
		  ExcelUtility elib = new ExcelUtility();
		  WebDriverUtility wlib=new WebDriverUtility();
		  
			String Browser = plib.getPropertyKeyValue("browser");
			String Url = plib.getPropertyKeyValue("url1");
			

			driver.get(Url);
			//String src="DEL, Delhi Airport India";
			//String Desc="BLR, Bengaluru International Airport India";
			
			driver.manage().window().maximize();
			wlib.moveByOffest(driver, 10, 10);
			WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
			WebElement des = driver.findElement(By.xpath("//input[@id='toCity']"));
			
			src.sendKeys("Bangkok");
			driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();			
      Thread.sleep(1000);
      
      des.sendKeys("Mumbai");
      driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
      Thread.sleep(1000);
      
      //navigate to Departure
      driver.findElement(By.xpath("//label[@for='departure']")).click();
      
      //navigate to desired date in calendar
      driver.findElement(By.xpath("//div[@aria-label='"+TravelDate+"']")).click();
			
	}

}
