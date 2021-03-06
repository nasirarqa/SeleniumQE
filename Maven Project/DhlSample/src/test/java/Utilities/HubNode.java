package Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HubNode {
	WebDriver driver;
	String browser = "firefox";
	String url = "https://www.bluedart.com";
	String nodeUrl = "http://192.168.0.235:6666/wd/hub";
	//String actualStatus;
	//String expectedStatus = "Shipment Delivered";
	
	

	@BeforeTest
	public void preLaunch() throws MalformedURLException{
	
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setBrowserName(browser);
		//capabilities.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
				
	}
	
	@Test
	public void launchUrl(){
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeDriver(){
		//driver.close();
		driver.quit();
	}
	
}
