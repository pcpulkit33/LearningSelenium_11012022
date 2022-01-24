package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverExample {

	WebDriver driver;
	
	String url = "https://www.flipkart.com/";
	
	@SuppressWarnings("deprecation")
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
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //implicit wait  
			driver.get(url);
			driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click();
			driver.findElement(By.linkText("Home")).click();
		}
	
	public void mouseMoverFlipkart() {
		
		By electronicsLinkLocator = By.xpath("//span[text()='Electronics']");
		
		WaitUtils.waitTillElementVisisble(driver, 10, electronicsLinkLocator);
		
		WebElement electronicsLink = driver.findElement(electronicsLinkLocator);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(electronicsLink).build().perform();
		
		By samsungLinkLocator = By.linkText("Samsung");
		
		WaitUtils.waitTillElementVisisble(driver, 20, samsungLinkLocator);
		
		WebElement samsungLink = driver.findElement(samsungLinkLocator);
		
		action.moveToElement(samsungLink).click(samsungLink).build().perform();
		
	}
			public static void main(String[] args) {
				MouseHoverExample mhe = new MouseHoverExample();
				mhe.invokeBrowser("chrome");
				mhe.mouseMoverFlipkart();
			}
	}
