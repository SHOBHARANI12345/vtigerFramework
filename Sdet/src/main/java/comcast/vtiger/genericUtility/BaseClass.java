package comcast.vtiger.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	
	propertyUtility	pboj=new propertyUtility();
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Execute Script in Parallel Mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
		String Browser = pboj.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		}
	  else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
			{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			}
			else
			{
				 driver = new ChromeDriver();
				 
			}
		sDriver=driver;
			}
		
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		System.out.println("Login to Application");
		String Url=pboj.getPropertyKeyValue("url");
		String UN=pboj.getPropertyKeyValue("un");
		String PW=pboj.getPropertyKeyValue("pw");
		driver.get(Url);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(UN, PW);
		}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM()
	{
		System.out.println("logout from Application");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC()
	{
		System.out.println("closing the Browser");
	}
    @AfterTest(groups= {"smokeTest","regressionTest"})
    public void At()
    {
    	System.out.println("parallel Execution is done");
    }	
    @AfterSuite(groups= {"smokeTest","regressionTest"})
    public void AS()
    {
    	System.out.println("Data Base Connection Close");
    }
    }

