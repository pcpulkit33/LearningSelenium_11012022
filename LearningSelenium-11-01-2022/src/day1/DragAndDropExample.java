package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {
	
	WebDriver driver; 
	
	String url = "https://test.qatechhub.com/drag-and-drop/";
	
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
	
	public void dragAndDrop() {
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		String colorbeforednd = target.getCssValue("color");
		
		Actions action = new Actions(driver);
		
		// action.dragAndDrop(source, target).build().perform();
		
		action.moveToElement(source).clickAndHold(source).moveToElement(target).release().build().perform();
		
		String colorafterdnd = target.getCssValue("color");
		
		System.out.println("color before drag and drop is " + colorbeforednd );
		System.out.println("color after drag and drop is " + colorafterdnd);
	}
	
	public static void main(String[] args) {
		 DragAndDropExample dnd = new DragAndDropExample();
		 dnd.invokeBrowser("chrome");
		 dnd.dragAndDrop();
	}
	}
		
