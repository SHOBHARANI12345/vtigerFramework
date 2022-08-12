package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage 
{
	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Declearation
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productCreateImage;

	@FindBy(xpath="//input[@name='productname']")
	private WebElement productTextField;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getProductCreateImage() {
		return productCreateImage;
	}
	//getter methods
	public WebElement getProductTextField() {
		return productTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
//Business Logics
	public void productCreateImage()
	{
		productCreateImage.click();	
	}
	
	public void productTextField(String ProductName)
	{
		productTextField.sendKeys(ProductName);
	}
	
	public void saveButton()
	{
		saveButton.click();	
	}
	
	
}
