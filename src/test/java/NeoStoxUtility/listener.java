package NeoStoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import NeoStoxPOM.Utilitynew;
import NeostoxBase.BaseNew;

public class listener extends BaseNew implements ITestListener 
{

	public void onTestSuccess(ITestResult result) 
	{  
		String MethodName = result.getName();
		Reporter.log("TC " +MethodName + " is comleted succefully", true);	
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+ " is failed",true);
		try {
		Utilitynew.takeScreenshot(driver, result.getName());
		} 
		catch (IOException e)
		{
		e.printStackTrace();
	    }
	}
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+ " is skiped plz cheak ", true);
	}
	
	
}


