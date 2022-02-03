package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99ProjectUsingTestNGDepedancyTesting {
	
	WebDriver driver;	
	String url = "https://demo.guru99.com/v4/";
	
	@Test
	public void invokeBrowser() { 
	
		String browserType = "chrome";
		if(browserType.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			
		} else 
		if(browserType.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\msedgedriver.exe");
			
			driver = new EdgeDriver();
	}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}	
	
	@Parameters({"userId", "userPass"})
	@Test (dependsOnMethods = "invokeBrowser")
	public void loginToApplication(String username, String password) {
		
		WebElement userID =  driver.findElement(By.name("uid"));
		
		userID.sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@Test(dependsOnMethods =  {"invokeBrowser", "loginToApplication"} )
	public void closeBrowser() {
		driver.quit();
	}
}

