package comcast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vtiger.genericUtility.WebDriverUtility;


public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
		@FindBy(linkText="Products")
		private WebElement productLinkText;
		
		@FindBy(linkText="More")
		private WebElement morelink;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignsLinkText;
		
		@FindBy(linkText="Organizations")
		private WebElement organizationLinkText;
		
		public WebElement getOrganizationLinkText() {
			return organizationLinkText;
		}
		public void setOrganizationLinkText(WebElement organizationLinkText) {
			this.organizationLinkText = organizationLinkText;
		}

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement signoutImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signoutLinkText;
		
//getter Methods
		public WebElement getSignoutImg() {
			return signoutImg;
		}
       public WebElement getSignoutLinkText() {
			return signoutLinkText;
		}
	    public WebElement getMorelink() {
			return morelink;
		}
        public WebElement getCampaignsLinkText() {
			return campaignsLinkText;
		}
         public WebElement getProductLinkText() 
		{
			return productLinkText;
		}
         //Business Logics
         public void clickProductLink()
		{
			productLinkText.click();
		}
		
		public void moreLink(WebDriver driver)
		{
		WebDriverUtility wlib = new WebDriverUtility();
			 wlib.mouseOverOnElement(driver, morelink);
		}
        public void campaignLinkText()
		{
			campaignsLinkText.click();
		}
        
        public void clickOrganizationsLinkText()
		{
			organizationLinkText.click();
		}

		public void signoutLink(WebDriver driver)
		{
			 
		      Actions act=new Actions(driver);
		          act.moveToElement(signoutImg).perform();
		        signoutLinkText.click();
		}
}
