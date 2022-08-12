package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dynamicpath {

	public static void main(String[] args) throws Throwable {
		String date="15";
		String yearAndMonth="September 2022";
		 String Key="webdriver.chrome.driver";
			String value="D:\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveByOffset(10, 10).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
	    String arrowXpath="//span[@aria-label='Next Month']";
	    
//		String dateXpath="//div[text()='"+yearAndMonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
//		for(;;) {
//		try {
//
//		driver.findElement(By.xpath(dateXpath)).click();
//
//		break;
//		} catch (Exception e) {
//
//		driver.findElement(By.xpath(arrowXpath)).click();
//
//		}
//		}

		}


}
