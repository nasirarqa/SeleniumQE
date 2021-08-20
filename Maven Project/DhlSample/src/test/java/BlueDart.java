import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueDart {
	
	WebDriver driver;
	String browser = "Chrome";
	static String url = "https://www.bluedart.com";
	static String actualStatus;
	static String expectedStatus = "Shipment Delivered";
	
	

	@BeforeTest
	public void launchUrl(){
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
	public void checkTracking(){
		WebElement waybillTextbox = driver.findElement(By.xpath("//div//textarea[@id='trackingNoTrackDart']"));
		waybillTextbox.sendKeys("38562625975");
		WebElement goButton = driver.findElement(By.xpath("//p//input[1][@id='goBtnTrackDart']"));
		goButton.click();
		
		WebElement statusText = driver.findElement(By.xpath("//div[@class='panel-group trackDart-box']//div[@class='panel-bd-List']//ul//li[2]//p"));
		actualStatus = statusText.getText();
		
		//assert actualStatus.contains(expectedStatus);
		
		if(actualStatus.contains(expectedStatus)){
			System.out.println("Shipment is delivered with the status "+ actualStatus);
		}
		else
		{
			System.out.println("Shipment is not delivered with the status "+actualStatus);
		}
		
	}	
		
	@AfterTest
	
	public void closeDriver(){
		driver.close();
		driver.quit();
			
	}
			
			
}

