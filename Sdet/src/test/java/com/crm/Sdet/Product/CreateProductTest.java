package com.crm.Sdet.Product;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.ProductCreationPage;
import comcast.vtiger.objectRepository.ProductValidation;

public class CreateProductTest extends BaseClass 
{
	@Test(groups={"smokeTest","regressionTest"})
	public void createProduct() throws Throwable 
{
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
		
		ProductValidation actualProductName = new ProductValidation(driver);
		String actualProductData = actualProductName.actualProductName();
		Assert.assertEquals(actualProductData.contains(productName), true);
		
//		String actData=driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
//		if(actData.contains(productName))
//        {
//       	 System.out.println("pass");
//        }
//        else
//        {
//       	 System.out.println("fail");
//        }
        homePage.signoutLink(driver);
	 }
	
		
	
	
}