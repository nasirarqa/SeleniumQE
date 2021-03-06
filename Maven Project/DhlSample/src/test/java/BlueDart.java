import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueDart {
	
	WebDriver driver;
	String browser = "Chrome";
	static String url = "https://www.bluedart.com";
	static String actualStatus;
	static String expectedStatus = "Shipment Delivered";
	
	

	@BeforeTest
	public void launchUrl() throws MalformedURLException{
		switch (browser){
		
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			default:
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
		
		}
	
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkTracking() throws InterruptedException{
		String udPath = System.getProperty("user.dir");
		String projPath = udPath+"\\Excel\\TestData.xlsx";
		Utilities.ExcelUtilities xlUtil = new Utilities.ExcelUtilities(projPath, "Waybill");
		int total = xlUtil.getRowCount();
		for(int i=1;i<total; i++){
			 Object cData = xlUtil.getCellData(i, 0);
			 Thread.sleep(5000);
		WebElement waybillTextbox = driver.findElement(By.xpath("//div//textarea[@id='trackingNoTrackDart']"));
		waybillTextbox.sendKeys(String.valueOf(cData));
		WebElement goButton = driver.findElement(By.xpath("//p//input[1][@id='goBtnTrackDart']"));
		goButton.click();
		
		WebElement statusText = driver.findElement(By.xpath("//div[@class='panel-group trackDart-box']//div[@class='panel-bd-List']//ul//li[2]//p"));
		actualStatus = statusText.getText();
		
			
		if(actualStatus.contains(expectedStatus)){
			System.out.println("Shipment is delivered with the status "+ actualStatus);
			WebElement bdLogo = driver.findElement(By.xpath("//img[@class='logoWidth']"));
			bdLogo.click();
		}
		else
		{
			System.out.println("Shipment is not delivered with the status "+actualStatus);
			WebElement bdLogo = driver.findElement(By.xpath("//img[@class='logoWidth']"));
			bdLogo.click();
		}	
		
		
		}
		
	}	
	
	@AfterMethod
	public void navHomePage(){
		WebElement bdLogo = driver.findElement(By.xpath("//img[@class='logoWidth']"));
		bdLogo.click();
	} 
		
	@AfterTest
	
	public void closeDriver(){
		driver.close();
		driver.quit();
			
	}
			
			
}


