package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImageUploadPractice {
	
	WebDriver driver;
	String url = "https://www.google.com/imghp?hl=en";
	
	public void invokebrowser(String browserType) {
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
	
		public void imageUpload() throws Exception {
			driver.findElement(By.xpath("//div[@aria-label='Search by image']")).click();
			driver.findElement(By.linkText("Upload an image")).click();
			
			WebElement moveToElement = driver.findElement(By.id("awyMjb"));
			
			Actions action = new Actions(driver);
			action.moveToElement(moveToElement).click(moveToElement).build().perform();
			
			Thread.sleep(3000);
			
			Runtime.getRuntime().exec("C:\\Users\\deepak.singh\\Desktop\\NEW.exe");
		}
		
		public static void main(String[] args) {
			
			try {
				ImageUploadPractice iup = new ImageUploadPractice();
				iup.invokebrowser("chrome");
				iup.imageUpload();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
