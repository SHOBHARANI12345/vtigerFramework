package com.crm.Sdet.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.propertyUtility;
import comcast.vtiger.objectRepository.CampaignCreationPage;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductCreationPage;
import comcast.vtiger.objectRepository.ValidationAndVerificationPage;

public class CreateCampaignWithProductNameTest extends BaseClass
{
	@Test(groups= {"smokeTest"})
public void createCampWithProduct() throws Throwable
	{
		String Key="webdriver.chrome.driver";
		String value="D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		propertyUtility pboj = new propertyUtility();
		String Url=pboj.getPropertyKeyValue("url");
		String UN=pboj.getPropertyKeyValue("un");
		String PW=pboj.getPropertyKeyValue("pw");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);

	    LoginPage loginpage = new LoginPage(driver);
		loginpage.login(UN, PW);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductLink();
		
		ProductCreationPage productPage = new ProductCreationPage(driver);
		productPage.productCreateImage();
		
		Java_utility jlib = new Java_utility();
		int ranNum=jlib.getRandomNum();
		
		ExcelUtility elib = new ExcelUtility();
		String productName=elib.getDataFromExcel("Product", 2, 0)+ranNum;
	   
		//ProductCreationPage productCreationPage = new ProductCreationPage(driver);
		productPage.productTextField(productName);
		productPage.saveButton();
		
		homePage.moreLink(driver);
		homePage.campaignLinkText();  
	      
		CampaignCreationPage campaignPage = new CampaignCreationPage(driver);
		campaignPage.campaignCreateImage();
	        
		Java_utility jlib1 = new Java_utility();
		int ranNum1=jlib1.getRandomNum();
		
		ExcelUtility elib1 = new ExcelUtility();
		String campaignName=elib1.getDataFromExcel("Campaign", 2, 0)+ranNum1;
	   
		//CampaignCreationPage campaignCreationPage = new CampaignCreationPage(driver);
		campaignPage.campaignTextField(campaignName);
		
		campaignPage.productSelectionImage(); 
		
		WebDriverUtility wlib = new WebDriverUtility();
	      wlib.switchToWindow(driver, "Products&action");

	      campaignPage.productTextField(productName);
	      campaignPage.searchProductButton(driver,productName);
	        
	       wlib.switchToWindow(driver, "Campaigns&action");
	       campaignPage.saveButton();
		       
	        String actData=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
			if(actData.contains(campaignName))
	        {
	       	 System.out.println("pass");
	        }
	        else
	        {
	       	 System.out.println("fail");
	        }
	 
            homePage.signoutLink(driver); 
	        driver.close();
	        }
}
