package com.crm.Sdet.organization;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.propertyUtility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.OrganizationCreationPage;
import comcast.vtiger.objectRepository.ValidationAndVerificationPage;
//@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass
{
	


	@Test(groups="regressionTest")
	public void createOrganization() throws Throwable
	{
	    String Key="webdriver.chrome.driver";
		String value="D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty(Key, value);
		


		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		propertyUtility plib = new propertyUtility();
	    Java_utility jlib = new Java_utility();
	    ExcelUtility elib = new ExcelUtility();
		
		String Browser = plib.getPropertyKeyValue("browser");
		String Url = plib.getPropertyKeyValue("url");
		String UserName= plib.getPropertyKeyValue("un");
		String Password = plib.getPropertyKeyValue("pw");

		driver.get(Url);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(UserName, Password);
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOrganizationsLinkText();
		
		OrganizationCreationPage orgCreationPage = new OrganizationCreationPage(driver);
		orgCreationPage.clickOrganizationCreateImage();
		
		//wantedly failing the script
	     Assert.assertEquals(false, true);
//		Random ran=new Random();
//	   int ranNum = ran.nextInt(1000);
       int RanNum = jlib.getRandomNum();
	   
       String orgName = elib.getDataFromExcel("Organization", 2, 0)+RanNum;
//		FileInputStream fis1=new FileInputStream("./Book1.xlsx");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sh = book.getSheet("Organization");
//		Row ro = sh.getRow(2);
//		  Cell cel = ro.getCell(0);
//              String orgName = cel.getStringCellValue()+RanNum;
     System.out.println(orgName);
     
     orgCreationPage.organizationNamesTextField(orgName);
     
     
     orgCreationPage.saveButton();
     
     ValidationAndVerificationPage data = new ValidationAndVerificationPage(driver);
      String actData=data.verificationOfOrganizationDataCreated();
      
//     if(actData.contains(orgName))
//     {
//    	 System.out.println("pass");
//     }
//     else
//     {
//    	 System.out.println("fail");
//     }
//     
//     Thread.sleep(2000);
     homePage.signoutLink(driver);
     driver.close();
     }
}