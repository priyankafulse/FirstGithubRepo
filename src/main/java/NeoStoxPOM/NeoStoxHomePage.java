package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxHomePage 
{
    @FindBy(xpath="(//a[text()='OK'])[2]")private WebElement OkButton;
	
    @FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closeButton;
    
    @FindBy(id="lbl_username")private WebElement UserName;
    
    @FindBy(id="lbl_curbalancetop")private WebElement Balance;
    
    @FindBy(xpath="//span[text()='Logout']")private WebElement logoutButton;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	
	public void PopupHandle(WebDriver driver)
	{
	    if (OkButton.isDisplayed()) 
	    {
	    	Utilitynew.Wait(driver, 1000);
	 	   OkButton.click();
	 	  // Utility.UtilityC.ScrollIntoView(driver, closeButton);
	 	   Utilitynew.Wait(driver, 2000);
	 	   closeButton.click();
	 	   Reporter.log("Handling popup", true); 
	    }
	    else
	    {    Utilitynew.Wait(driver, 2000);
	    	 Reporter.log("There is no popup", true);
	    }
	} 
	
	 public String getUserName()
	 {
	   String ActualUserName = UserName.getText();	
	   Reporter.log("getting userName", true);  
	   return ActualUserName;
	 }
	 
	 public String GateBalance(WebDriver driver)
	 {
		Utilitynew.Wait(driver, 1000);
		String actualBalance = Balance.getText();
		Reporter.log("getting Actual Balance", true); 
		return actualBalance;		 
	 }
	
	 public void LogoutFromNeostox(WebDriver driver)
	 {
		 Utilitynew.Wait(driver,1000);
		 UserName.click();
		 Utilitynew.Wait(driver,1000);
		 logoutButton.click();
		 Reporter.log("logging out from Neostox", true); 
	 }

	 
	 
	}

