package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initalization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
    private WebElement userPasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//getter methods
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUserPasswordTextField() {
		return userPasswordTextField;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	
	//business logics
	/**
	 *used for login app 
	 * @param userName
	 * @param passWord
	 * @author Shobha
	 */
	public void login(String userName,String passWord)
	{
		userNameTextField.sendKeys(userName);
		userPasswordTextField.sendKeys(passWord);
		loginButton.click();
		
	}


	
	
}
