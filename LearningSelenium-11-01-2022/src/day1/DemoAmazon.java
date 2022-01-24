package day1;

public class DemoAmazon {

	public static void main(String[] args) {

		Amazon amazon = new Amazon();

		amazon.invokeBrowser("chrome");
		
		amazon.getAllProductsUrlAndLinktext();

		/*
		 * amazon.searchProduct("iphone", "Electronics");
		 * 
		 * amazon.getAllProductsViaScrollDownUsingJS();
		 * 
		 * 
		 * String productDetails = amazon.getNthproduct(12);
		 * 
		 * System.out.println(productDetails);
		 */

	}

}
