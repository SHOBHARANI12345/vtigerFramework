package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.WebDriverUtility;

public class dynamic {

	public static void main(String[] args) {
		
		String month="Nov";
		int date=19;

		WebDriverUtility wlib = new WebDriverUtility();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		
	
		driver.findElement(By.xpath("//span[text()='DEPARTURE' and  @class='lbl_input latoBold appendBottom10']")).click();
		String nextMonthArrow = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";

		String dateXpath = "//div[@class='dateInnerCell']/descendant::p[text()='"+date+"']/parent::div[@class='dateInnerCell']/parent::div[contains(@aria-label,'"+month+"')]";
		                       //  "//div[@class='dateInnerCell']/descendant::p[text()='13']/parent::div[@class='dateInnerCell']/parent::div[contains(@aria-label,'May')]"
		for(;;) {
		try {
		driver.findElement(By.xpath(nextMonthArrow)).click();
		break;
		}
		catch (Exception e) {
		WebElement ClickDate = driver.findElement(By.xpath(dateXpath));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ClickDate);
		break;
		}
		}

		driver.quit();
		}
		

}