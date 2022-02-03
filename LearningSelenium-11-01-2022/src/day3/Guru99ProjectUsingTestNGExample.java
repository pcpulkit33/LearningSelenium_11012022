package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99ProjectUsingTestNGExample {
	
	WebDriver driver;
	
	String url = "https://demo.guru99.com/v4/";
	
	@Test (groups = "invokeBrowser")
	@Parameters("browserType")
	public void invokeBrowser(String browserType) { 
	
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
	
	@Test(groups = "Signin", dependsOnGroups = "invokeBrowser")
	@Parameters({"userId","userPass"})
	public void loginToApplication(String username ,String password) {
		
		WebElement userID =  driver.findElement(By.name("uid"));
		
		userID.sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@Test
	public void closeBrowser() {
		driver.quit();
	}
}

