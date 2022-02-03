package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImageUpload {

	WebDriver driver;
	String url = "https://www.google.com/imghp?hl=en";
	
	public void invokeBrowser(String browserType) {
		if(browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		}
			else if(browserType.equals("edge")) {
				System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\msedgedriver.exe");
			driver = new EdgeDriver();	
			}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
		}
	
	public void imageUpload() throws Exception {
		
		driver.findElement(By.xpath("//div[@aria-label=\"Search by image\"]")).click();
		driver.findElement(By.linkText("Upload an image")).click();
		
		WebElement choosebutton = driver.findElement(By.id("awyMjb"));
		
		Actions action = new Actions(driver);
		action.moveToElement(choosebutton).click(choosebutton).build().perform();
		
		Thread.sleep(5000);
	 
		Runtime.getRuntime().exec("C:\\Users\\deepak.singh\\Desktop\\Account_info.exe");
		
	}
	
	public static void main(String[] args) {
		
		try {
			ImageUpload iu = new ImageUpload();
			iu.invokeBrowser("chrome");
			iu.imageUpload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

	
