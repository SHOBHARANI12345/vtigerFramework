package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage 
{
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.lvtHeaderText")
	private WebElement actualProductData;
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualCampaignData;
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualOrganizationData;
	
	@FindBy(css="input[title='Delete [Alt+D]']")
	private WebElement deleteButton;
	
	

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(WebElement deleteButton) {
		this.deleteButton = deleteButton;
	}

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	public void setActualOrganizationData(WebElement actualOrganizationData) {
		this.actualOrganizationData = actualOrganizationData;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}

	public void setActualCampaignData(WebElement actualCampaignData) {
		this.actualCampaignData = actualCampaignData;
	}

	public WebElement getActualProductData() {
		return actualProductData;
	}

	public void setActualProductData(WebElement actualProductData) {
		this.actualProductData = actualProductData;
	}
	
	public void verificationOfProductDataCreated(String productName)
	{
		String actData=actualProductData.getText();
		if(actData.contains(productName))
        {
       	 System.out.println("pass");
        }
        else
        {
       	 System.out.println("fail");
        }
 
	}

	public void verificationOfCampaignDataCreated(String campaignName)
	{
		String actData=actualCampaignData.getText();
		if(actData.contains(campaignName))
        {
       	 System.out.println("pass");
        }
        else
        {
       	 System.out.println("fail");
        }
 
	}
	
	
	public String verificationOfOrganizationDataCreated()
	{
		return actualProductData.getText();
	

}
	
	public String verificationOfProductData(String productName)
	{
		return actualProductData.getText();
	
	
}
	


public void clickDeleteButton()
{
	deleteButton.click();
	
}}