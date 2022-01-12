package day1;

public class DemoGuru99 {
	
	public static void main(String[] args) {
		
		Guru99Project guru = new Guru99Project();
		guru.invokeBrowser("chrome");
		guru.loginToApplication("mngr379944", "Ahapeve");
		guru.addNewCustomer();
//		guru.closeBrowser();
	}

}
