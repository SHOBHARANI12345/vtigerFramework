package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws Throwable
 {
String Key="webdriver.chrome.driver";
String value="D:\\chromedriver_win32\\chromedriver.exe";
System.setProperty(Key, value);
FileInputStream fis=new FileInputStream("./CommonProperty.properties");
Properties pboj=new Properties();
pboj.load(fis);

String Url=pboj.getProperty("url");
String UN=pboj.getProperty("un");
String PW=pboj.getProperty("pw");

WebDriver driver=new ChromeDriver();
driver.get(Url);

driver.findElement(By.name("user_name")).sendKeys(UN);
driver.findElement(By.name("user_password")).sendKeys(PW);
driver.findElement(By.id("submitButton")).click();

	}

}
