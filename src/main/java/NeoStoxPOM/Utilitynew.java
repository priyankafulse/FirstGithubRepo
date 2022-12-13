package NeoStoxPOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utilitynew {

	//public static void main(String[] args) throws IOException 
	//{
	//	System.out.println(readDataFromPropertyFile("mobileNum"));
    //
	// }
	
    public static String readDataFromPropertyFile(String key) throws IOException
    {
    	//create object of properties class
    	
    	Properties prop =new Properties();
    	
    	//create object of fileInputSteram
    	FileInputStream myfile=new FileInputStream("C:\\Users\\Dell 94\\Desktop\\Priyanka\\FirstMavenProject\\MavenPropertyFile");
    	
    	prop.load(myfile);
    	
        String value = prop.getProperty(key);
        Reporter.log("Reading value of "+key+"from property file",true);
        return value; 	
    }
    

	 public static void takeScreenshot(WebDriver driver, String FileName) throws IOException
	 {		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		File Destination=new File("E:\\java selenium\\ScreenShot\\"+FileName +".jpg");
		FileHandler.copy(source, Destination);
		Reporter.log("Taking screenshot ", true);
	 }
	 
	 
	 public static void ScrollIntoView(WebDriver driver,WebElement element)
	 {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoview(true)",element);
		Reporter.log("SCreolling Into View"+element.getText(), true);
	 } 
	 	 
		 
	 public static void Wait(WebDriver driver, int WaitTime)
	 {
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(WaitTime));
		Reporter.log("Wating for "+ WaitTime+"milis", true);
		 
	 }
}
