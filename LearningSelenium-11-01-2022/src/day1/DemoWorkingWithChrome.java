package day1;

public class DemoWorkingWithChrome {

	public static void main(String[] args) {
		
		WorkingWithChrome wc = new WorkingWithChrome();
		
		wc.invokeBrowser();
		String title = wc.getTitle();
		System.out.println("title of this page is -"+ title);
		wc.navigateCommands();
		wc.closeBrowser();
		
	}
}
