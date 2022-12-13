package NeostoxBase;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import NeoStoxPOM.Utilitynew;
public class BaseNew
{
	 protected static WebDriver driver; 
   public void launchBrowser() throws IOException
   {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell 94\\Desktop\\Chromedriver\\chromedriver_win32 (1)\\chromedriver.exe");		
		driver=new ChromeDriver();
		
		//driver.get(Utilitynew.readDataFromPropertyFile("url"));
		driver.get(Utilitynew.readDataFromPropertyFile("url"));
        driver.manage().window().maximize();
        Reporter.log("Launch the browser ", true);
        Utilitynew.Wait(driver,2000);
   }
    public static void closingBrowser(WebDriver driver) throws  InterruptedException
    {
  	
     Reporter.log("closing browser", true);
     Thread.sleep(500);
     driver.close();
    }
}