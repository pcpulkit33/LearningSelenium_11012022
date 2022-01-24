package day1;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {
	
	WebDriver driver;
	
	String url = "https://demo.guru99.com/v4/";
	
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
	
	public void loginToApplication(String username, String password) {
		
		WebElement userID =  driver.findElement(By.name("uid"));
		
		userID.sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
	}
	
	public void addNewCustomer() { 
		
		driver.findElement(By.linkText("New Customer")).click();
		
		Random r = new Random();
		char ch=(char)(r.nextInt(26) + 'a');
		
		driver.findElement(By.name("name")).sendKeys("Pulkit"+ " " + ch + "jkl");
		
		driver.findElement(By.xpath("//input[@value='m']"));
		driver.findElement(By.name("dob")).sendKeys("12-02-1994");
		driver.findElement(By.name("addr")).sendKeys("D 600 Sec 62");
		driver.findElement(By.name("city")).sendKeys("Noida");
		driver.findElement(By.name("state")).sendKeys("Uttar Pradesh");
		driver.findElement(By.name("pinno")).sendKeys("201301");
		driver.findElement(By.name("telephoneno")).sendKeys("999000999");
		
		String emailid = "ss" + System.currentTimeMillis() + "@gmail.com";
		
		driver.findElement(By.name("emailid")).sendKeys(emailid);
		driver.findElement(By.name("password")).sendKeys("Pulkit@1234");
		driver.findElement(By.name("sub")).click();
		
		
	}
	
	public String getCustomerId() {
		return driver.findElement(By.xpath("//table[@id='customer']//td[text()='Customer ID']//following-sibling::td")).getText();
	}
	
	public void addAccount(String customerId) {
		driver.findElement(By.linkText("New Account")).click();
		
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		
		//dropdown selection :- Select is a class defined in selenium.
		WebElement selDropdown = driver.findElement(By.name("selaccount"));
		Select select = new Select(selDropdown);
		System.out.println(select.isMultiple());
		select.selectByVisibleText("Current");
		driver.findElement(By.name("inideposit")).sendKeys("2000");
		driver.findElement(By.name("button2")).click();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}

