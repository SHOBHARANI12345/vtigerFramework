package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.propertyUtility;

public class DynamicXpath3 {

	public static void main(String[] args) throws Throwable {
		 
		String MonthAndYear = "December 2022";
		int date=7;
		String Key="webdriver.chrome.driver";
			String value="D:\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(Key, value);
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			propertyUtility plib = new propertyUtility();
		   Java_utility jlib = new Java_utility();
		  ExcelUtility elib = new ExcelUtility();
		  WebDriverUtility wlib=new WebDriverUtility();
		  
			//String Browser = plib.getPropertyKeyValue("browser");
		  // String Url = plib.getPropertyKeyValue("url2");
			

			driver.get("https://www.goibibo.com/flights/");
			driver.findElement(By.xpath("//span[text()='Departure']")).click();
			for(;;)
			{
				try
				{
				driver.findElement(By.xpath("//div[text()='August 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='10']")).click();
				driver.findElement(By.xpath("//span[text()='Done']")).click();
				}
				catch (Exception e) {
					driver.findElement(By.xpath("//span[@aria-label='Next Month;]")).click();
				}
			}
			
			

	}

}
