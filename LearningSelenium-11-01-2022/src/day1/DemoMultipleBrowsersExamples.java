package day1;

public class DemoMultipleBrowsersExamples {
	
	public static void main(String[] args) {
		
		MultipleBrowserExamples mb = new MultipleBrowserExamples();
		
		try {
			mb.invokeBrowser("edge");
			String title = mb.getTitle();
			System.out.println("The title of page is - "+ title);
			mb.closeBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
