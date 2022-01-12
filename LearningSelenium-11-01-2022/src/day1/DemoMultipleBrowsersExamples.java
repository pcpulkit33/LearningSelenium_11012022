package day1;

public class DemoMultipleBrowsersExamples {
	
	public static void main(String[] args) {
		
		MultipleBrowserExamples mb = new MultipleBrowserExamples();
		
		mb.invokeBrowser("edge");
		String title = mb.getTitle();
		System.out.println("The title of page is - "+ title);
		mb.closeBrowser();
		}
}
