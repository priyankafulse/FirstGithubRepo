package NeoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import NeoStoxPOM.NeoStoxHomePage;
import NeoStoxPOM.NeoStoxPassword;
import NeoStoxPOM.NeostoxSignIn;
import NeoStoxPOM.Utilitynew;
import NeostoxBase.BaseNew;
@Listeners(NeoStoxUtility.listener.class)
public class ValidateNeoStocksUserNamePropertiesFile extends BaseNew
{
	NeostoxSignIn login;
	NeoStoxPassword password;
	NeoStoxHomePage home;
	
   @BeforeClass	
   public void launchNeoStox() throws IOException
   {
	   launchBrowser();
	   login =new NeostoxSignIn(driver);
	   password=new NeoStoxPassword(driver);
	   home=new NeoStoxHomePage (driver);
   }
	
	@BeforeMethod
	public void LoginToNewStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.SendMobNumb(driver,Utilitynew.readDataFromPropertyFile("mobileNum"));
		login.ClickOnSignButton(driver);
		Thread.sleep(1000);
		password.SendPassword(driver,Utilitynew.readDataFromPropertyFile("password"));
		password.clickOnSubmitButton();
		Thread.sleep(1000);
		home.PopupHandle(driver);
	}
	
    @Test
    public void ValidateUserName() throws EncryptedDocumentException, IOException 
     {
	   Assert.assertEquals(home.getUserName(),Utilitynew.readDataFromPropertyFile("username"));
	   Utilitynew.takeScreenshot(driver, home.getUserName());
     }
    
    
    @AfterMethod
    public void logout()
    {
    	home.LogoutFromNeostox(driver);
    }
    @AfterClass
    public void closeApplication() throws InterruptedException
    {
    closingBrowser(driver);
    }
		
}
