package comcast.vtiger.genericUtility;

import java.util.Random;

public class Java_utility {
	/**
	 * This method is used for Concatenate to Excel data
	 * @author Shobha
	 */

	public int getRandomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
				
		return RanNum;
		
	}
	

}
