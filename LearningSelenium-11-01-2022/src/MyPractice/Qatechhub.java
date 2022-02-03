package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Qatechhub {
	
	WebDriver driver;
	
	String url = "https://test.qatechhub.com/form-elements/";
	
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
		public void closeBrowser() {
			driver.close();
		}
	
		public void FillForm(String category) {
			driver.findElement(By.id("wpforms-49-field_1")).sendKeys("Pulkit");
			driver.findElement(By.id("wpforms-49-field_1-last")).sendKeys("Chaudhary");
			
			String email = "pu" + System.currentTimeMillis() + "@gmail.com" ;
					
			driver.findElement(By.id("wpforms-49-field_2")).sendKeys(email);
			driver.findElement(By.id("wpforms-49-field_4")).sendKeys("9900990099");
			driver.findElement(By.id("wpforms-49-field_3_1")).click();
			
			WebElement selDropdown = driver.findElement(By.id("wpforms-49-field_5"));
			
			Select selCategory = new Select(selDropdown);
			selCategory.selectByVisibleText(category);
			
			driver.findElement(By.name("wpforms[submit]")).click();
		}
}
