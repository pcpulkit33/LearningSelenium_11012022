package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleBrowserExamples {

	WebDriver driver;
	
	String url = "https://qatechhub.com";
	
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
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() { 
		driver.quit();
	}
	

}
