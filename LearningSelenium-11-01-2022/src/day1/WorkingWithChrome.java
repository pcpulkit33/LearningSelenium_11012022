package day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {

	ChromeDriver driver;
	
	String url = "https://test.qatechhub.com";
	
	public void invokeBrowser () {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();//method chaining
		
		Dimension dim = new Dimension(1024, 680);
		
		driver.manage().window().setSize(dim);
		
		driver.manage().deleteAllCookies(); //bypass cookies
		
		driver.get(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void navigateCommands() {
		driver.navigate().to(url);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	
	public void closeBrowser() {
		//closes the active window 
//		driver.close();
		
		//close all the windows which are opened by Selenium session
		driver.quit();
	}
	
	
}