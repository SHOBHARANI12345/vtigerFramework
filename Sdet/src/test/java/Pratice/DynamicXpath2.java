package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.propertyUtility;

public class DynamicXpath2 {

	public static void main(String[] args) throws Throwable {
		
		  String Key="webdriver.chrome.driver";
			String value="D:\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(Key, value);
			


			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			propertyUtility plib = new propertyUtility();
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
    
   String src1="Mumbai, India";
    des.sendKeys("Mumbai");
    driver.findElement(By.xpath("//p[text()='"+src1+"']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
    //navigate to Departure
    driver.findElement(By.xpath("//label[@for='departure']")).click();
    String requiredMonth="November";
    String requiredYear="2022";
    String requiredDate="15";
   
    String currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
    String currentMonth=currentMonthYear.split(" ")[0];
    String currentYear=currentMonthYear.split(" ")[1];
    
  //  !(Aug=Nov)&&(2022=2022) ! (Nov=Nov)&&(2022=2022)
    while(!(currentMonth.equalsIgnoreCase(requiredMonth) && currentYear.equals(requiredYear))) {
    	driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
    	    currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
    	     currentMonth=currentMonthYear.split(" ")[0];
    	     currentYear=currentMonthYear.split(" ")[1];
    	     
    }
    driver.findElement(By.xpath("(//p[text()='"+requiredDate+"'])[1]")).click();
    
}
}
