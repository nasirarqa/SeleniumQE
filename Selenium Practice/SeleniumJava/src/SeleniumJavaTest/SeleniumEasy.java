package SeleniumJavaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumEasy {
	WebDriver driver;
	static String url = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
	String browser;
	
	SeleniumEasy(String browser){
		this.browser = browser;
		switch (browser){
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		break;
		case "Chrome": //change is with chrome driver
			System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver\\geckodriver.exe");
			driver = new ChromeDriver();
		break;
		case "Edge": //change it with Edge driver
			System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver\\geckodriver.exe");
			driver = new EdgeDriver();
		break;
		default: //change it with IE driver
			System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver\\geckodriver.exe");
			driver=new InternetExplorerDriver();
		break;
		}
	}
	
		
	public static void main(String[] args) throws InterruptedException {
		SeleniumEasy SE = new SeleniumEasy("Firefox");
		
		SE.driver.get(url);
		
		SE.driver.manage().window().maximize();
		//SE.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		WebElement noThanksButton = SE.driver.findElement(By.xpath("//div[@id='at-cv-lightbox-content']//a[2]"));
		if(noThanksButton.isDisplayed()){
			noThanksButton.click();
			System.out.println("No Thanks button is clicked");
		}else{
			System.out.println("No Thanks Button is not displayed");
		}
		
		WebElement enterMsgTxtbox = SE.driver.findElement(By.id("user-message"));
		enterMsgTxtbox.sendKeys("This is my first selenium code");
		//Textbox.sendKeys(Keys.ENTER);
		//Textbox.clear();

		
		WebElement showMsgButton = SE.driver.findElement(By.xpath("//div//button[contains(text(),'Show Message')]"));
		showMsgButton.click();
				
		WebElement enterATxtbox = SE.driver.findElement(By.cssSelector("input[id='sum1']"));
		enterATxtbox.sendKeys("10");
		
		WebElement enterBTxtbox = SE.driver.findElement(By.cssSelector("input[id='sum2']"));
		enterBTxtbox.sendKeys("5");				
		
		WebElement totalButton = SE.driver.findElement(By.xpath("//form[@id='gettotal']//button"));
		totalButton.click();
		
		
	}
}


