package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxSignIn {

	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement  MobileNumField;
		
	@FindBy(xpath="//a[@id='lnk_signup1']") private WebElement SignInButton;	
	
    public NeostoxSignIn(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
	
	public void SendMobNumb(WebDriver driver, String mobNum)
	{		
		Utilitynew.Wait(driver,1000);
		MobileNumField.sendKeys(mobNum);
		Reporter.log("sending mobile number", true);
	}
	
	public void ClickOnSignButton(WebDriver driver)
	{		
		Utilitynew.Wait(driver,1000);
		SignInButton.click();
		Reporter.log("clicking on sign Button", true);
	}
	

	
	
}
