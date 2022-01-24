package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitTillElementVisisble(WebDriver driver, int timeoutInSeconds, By locator) {
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

	public static void waitTillElementIsClickable(WebDriver driver, int timeoutInSeconds, By locator ) { 
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitTillAlertIsPresent (WebDriver driver, int timeoutInSeconds) { 
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
