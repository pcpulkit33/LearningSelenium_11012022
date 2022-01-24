package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Guru99LogoutAlertHandling {
	
	WebDriver driver;
	
	String url = "https://demo.guru99.com/v2/";
	
	public void invokeBrowser(String browserType) {
		
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserType.equals("edge")) {
			System.setProperty("Webdriver.edge.driver", 
					"C:\\Users\\deepak.singh\\eclipse-workspace\\libs\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	
	public void loginTOGuru99(String login, String password) {
		
		driver.findElement(By.name("uid")).sendKeys(login);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	public void logoutFromGuru99() {
		
		driver.findElement(By.linkText("Log out")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
//		  alert.accept(); 
//		  alert.dismiss();
		 
	}
	
	public static void main(String[] args) {
		
		Guru99LogoutAlertHandling guru99ll = new Guru99LogoutAlertHandling();
		
		guru99ll.invokeBrowser("chrome");
		guru99ll.loginTOGuru99("mngr379944", "Ahapeve");
		guru99ll.logoutFromGuru99();
		
	}
}
