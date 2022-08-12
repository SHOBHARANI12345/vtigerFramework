package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyUtility {

	public String getPropertyKeyValue(String Key) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("./CommonProperty.properties");
		 Properties pro = new Properties();
		 pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
		
	}
	


}
