package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class MercuryTravelProject {
	
	WebDriver driver;
	String url = "https://www.mercurytravels.co.in/";

	public void invokeBrowser(String browserType) {
		
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		} else 
			if (browserType.equals("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
			
			ChromeOptions chrOptions = new ChromeOptions();
			
			chrOptions.addArguments("--headless");
			
			driver = new ChromeDriver(chrOptions);
			
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

	public void defaultVerification() {
			
		driver.findElement(By.id("flights")).click();
		WebElement roundTripRadioButton = driver.findElement(By.xpath("//input[@value='R']"));
		
		if(roundTripRadioButton.isSelected()) {
			System.out.println("Default value is correct"); }
			else {
				System.out.println("Fail");
			}
		
		WebElement dateOfReturn = driver.findElement(By.id("dpf2"));
			if(dateOfReturn.isEnabled()) {
				System.out.println("Date of return is displayed");
			}
		}
	
	public static void main(String[] args) {
		MercuryTravelProject mtp = new MercuryTravelProject();
		mtp.invokeBrowser("chrome");
		mtp.defaultVerification();
	}
	
}
