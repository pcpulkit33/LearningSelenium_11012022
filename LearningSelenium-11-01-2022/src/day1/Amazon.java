package day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	WebDriver driver;
	String url = "https://www.amazon.in/";
	
	@SuppressWarnings("deprecation")
	public void invokeBrowser(String browserType) {
		
		if(browserType.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", 
			"C:\\\\Users\\\\deepak.singh\\\\eclipse-workspace\\\\libs\\\\chromedriver.exe");
			
			driver = new ChromeDriver();
		} else 
		if(browserType.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver", 
			"C:\\\\Users\\\\deepak.singh\\\\eclipse-workspace\\\\libs\\\\msedgedriver.exe");
			
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	public void getAllProductsUrlAndLinktext() {
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (WebElement link : allLinks) {
			
			System.out.println("Text is " + link.getText());
			
			System.out.println("URL is " + link.getAttribute("href"));
			
			System.out.println("--------------------------------------------------");
			
		}
		
	}
	
	
	public void searchProduct(String product, String category) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(product);
		
		WebElement selDropDown = driver.findElement(By.id("searchDropdownBox"));
		
		Select selCategory = new Select(selDropDown);
		
		selCategory.selectByVisibleText(category);
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}
	
	public String getNthproduct (int productnumber) {
		String XpathExpression = 
			String.format("//div[@data-component-type='s-search-result' and @data-index='%d']", productnumber);
		return driver.findElement(By.xpath(XpathExpression)).getText();
	}
	
	public void getAllProduct() {
		
	List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
	
	for ( WebElement product : allProducts ) {
		System.out.println(product.getText());
		
		System.out.println("----------------");
	}
	}
	
	public void getAllProductsViaScrollDownUsingActionsClass() {
		
	List<WebElement> allproducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
	
	Actions action = new Actions(driver);
	
	for( WebElement temp : allproducts ) {
		
		action.moveToElement(temp).build().perform();
		
		 System.out.println(temp.getText());
		 
		 System.out.println("------------------------------");
			}
	}	
	
	public void getAllProductsViaScrollDownUsingJS() {
		
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		
		int xCordinate; 
		int yCordinate;
		
		for( WebElement temp : allproducts ) {
			
			xCordinate = temp.getLocation().x;
			yCordinate = temp.getLocation().y;
			
			scrollBy(xCordinate, yCordinate);
			
			 System.out.println(temp.getText());
			 
			 System.out.println("------------------------------");
		}
	
	}

	public void scrollBy(int X, int Y) {
		
		JavascriptExecutor jsEngine;
		
		jsEngine = (JavascriptExecutor) driver;
		
		String jsCommand = String.format("window.scrollBy(%d,%d)", X, Y);
		
		jsEngine.executeScript(jsCommand);
	}

}