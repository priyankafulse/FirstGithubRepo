package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeoStoxPassword 
{
  
	@FindBy(id="txt_accesspin")private WebElement passwordField;
	
	@FindBy(xpath="//a[text()='Submit']")private WebElement submitButton;
	
	public NeoStoxPassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void SendPassword(WebDriver driver,String pass)
	{
		passwordField.sendKeys(pass);
	}
	
	public void clickOnSubmitButton()
	{
		submitButton.click();
	}
}
