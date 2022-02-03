package MyPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTripProject {
	
WebDriver driver;
	
	String url = "https://www.makemytrip.com/";
	
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
		public void bookMyFlight () throws InterruptedException {
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class=\"fsw_inputBox searchCity inactiveWidget \"]/label")).sendKeys("kol");;
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class=\"hsw_autocomplePopup autoSuggestPlugin \"]/div/input")).sendKeys("Kolkata");
			
			List<WebElement> element = driver.findElements(By.cssSelector("p[class=\"font14 appendBottom5 blackText\"]"));
			
			for (int i=0; i<element.size(); i++) {
				String text = element.get(i).getText();
				System.out.println("text is" + text);
				if(text.contains("Kolkata")) {
					WebElement button = element.get(i);
					button.click();
					break;
				}
			}
			
			driver.findElement(By.id("toCity")).sendKeys("del");
			driver.findElement(By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]")).sendKeys("del");
			driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
			
		}
	
		public void closeBrowser() {
			driver.close();
		}

		public static void main(String[] args) throws InterruptedException {
			
			MakeMyTripProject bookflight = new MakeMyTripProject();
			bookflight.invokeBrowser("chrome");
			bookflight.bookMyFlight();
		//	bookflight.closeBrowser();
		}
}
