package com.crm.Sdet.Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.propertyUtility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductCreationPage;
import comcast.vtiger.objectRepository.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createProductAndDelete 
{
	
	
	@Test(groups= {"smokeTest","regression"})
	public void createProductAndDelete() throws Throwable
	{
			String Key="webdriver.chrome.driver";
			String value="D:\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(Key, value);
			propertyUtility plib=new propertyUtility();
			String Browser = plib.getPropertyKeyValue("browser");
		
			
			String Url = plib.getPropertyKeyValue("url");
			String UserName= plib.getPropertyKeyValue("un");
			String Password = plib.getPropertyKeyValue("pw");

			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(Url);

			LoginPage loginpage = new LoginPage(driver);
			loginpage.login(UserName, Password);
			
			HomePage homePage = new HomePage(driver);
			homePage.clickProductLink();
			
			ProductCreationPage productPage = new ProductCreationPage(driver);
			productPage.productCreateImage();
			
			Java_utility jlib = new Java_utility();
			int ranNum=jlib.getRandomNum();
			
			ExcelUtility elib = new ExcelUtility();
			String productName=elib.getDataFromExcel("Product", 2, 0)+ranNum;
		   
			productPage.productTextField(productName);
			productPage.saveButton();
			
			ValidationAndVerificationPage data = new ValidationAndVerificationPage(driver);
		     String actData =data.verificationOfProductData(productName);
	        if(actData.contains(productName))
	        {
	       	 System.out.println("pass");
	        }
	        else
	        {
	       	 System.out.println("fail");
	        }
	        
	        data.clickDeleteButton();
	        
			WebDriverUtility wlib=new WebDriverUtility();
			wlib.switchToAlertAndAccpect(driver);
	        
	       
			homePage.signoutLink(driver);
		     driver.close();
		     }

}
