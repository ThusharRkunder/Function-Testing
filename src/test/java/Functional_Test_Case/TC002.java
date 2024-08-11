package Functional_Test_Case;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class TC002 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		 try {
	            // Open the URL
	            driver.get("https://demo.dealsdray.com/");

	            // Maximize the window
	            driver.manage().window().maximize();

	            // Implicit wait
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	            // Login
	            WebElement inputUserName = driver.findElement(By.xpath("//input[@name=\"username\"]"));  
	            WebElement inputPassword = driver.findElement(By.xpath("//input[@name=\"password\"]"));  
	            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),\"Login\")]")); 

	            inputUserName.sendKeys("prexo.mis@dealsdray.com");
	            TimeUnit.SECONDS.sleep(2);
	            inputPassword.sendKeys("prexo.mis@dealsdray.com");
	            loginButton.click();
	            TimeUnit.SECONDS.sleep(2);
	            WebElement orderButton = driver.findElement(By.xpath("//span[text()=\"Order\"]")); 
	            orderButton.click();
	            TimeUnit.SECONDS.sleep(2);
	            WebElement ordersButton = driver.findElement(By.xpath("//span[text()=\"Orders\"]")); 
	            ordersButton.click();
	            TimeUnit.SECONDS.sleep(2);
	            WebElement addBulkButton = driver.findElement(By.xpath("//button[contains(text(),\"Add Bulk Orders\")]")); 
	            addBulkButton.click();
	            TimeUnit.SECONDS.sleep(2);
	            String currentDir = System.getProperty("user.dir");
	            
	            // Upload XLS file
	            WebElement uploadButton = driver.findElement(By.xpath("//input[contains(@id,\"mui\")]")); 
	            uploadButton.sendKeys(currentDir+"\\Excel_file\\demo-data.xlsx");

	            // Wait for file to upload 
	            TimeUnit.SECONDS.sleep(5);
	            WebElement importButton = driver.findElement(By.xpath("//button[text()=\"Import\"]"));
	            importButton.click();
	            TimeUnit.SECONDS.sleep(2);
	          //button[text()="Validate Data"]
	            WebElement validateButton = driver.findElement(By.xpath("//button[text()=\"Validate Data\"]")); 
	            validateButton.click();
	            TimeUnit.SECONDS.sleep(5);
	         // Switch to the alert
	            Alert alert = driver.switchTo().alert();
	            // Accept the alert (click OK)
	            alert.accept();
	            TimeUnit.SECONDS.sleep(2);
//	            TakesScreenshot interface for ScreenShots
	            TakesScreenshot ts = (TakesScreenshot) driver;
	    		File src = ts.getScreenshotAs(OutputType.FILE);
	    		File target = new File(".\\ScreenShots\\page.png");
	    	// Copy the screenshot from the source file (src) to the target location
                FileUtils.copyFile(src, target);
	    		
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	
	

}
