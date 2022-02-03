package MyPractice;

public class DemoQatechhub {
	
	public static void main(String[] args) {
		
		Qatechhub qa = new Qatechhub();
		
		qa.invokeBrowser("chrome");
		
		qa.FillForm("Selenium");
		
		qa.closeBrowser();
	}

}
