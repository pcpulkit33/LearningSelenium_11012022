
package day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTesting {
	
	@BeforeClass (alwaysRun = true)
	public void beforeClass() {
		System.out.println("Execute as 1st method when this class load");
	}
	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		System.out.println("Execute as last method when this class load");
	}
	

	@BeforeMethod (alwaysRun = true)
	public void beforeMethod() {
		System.out.println("Before every test case : ");
	}
	
	@AfterMethod (alwaysRun = true)
	public void afterMethod() {
		System.out.println("After every test case :");
	}
	
	@Test(groups = {"Sanity"})
	public void testCase1() {
		System.out.println("TestCase 1");
	}

	@Test
	public void testCase3() {
		System.out.println("TestCase 3");
	}
	
	@Test
	public void testCase8() {
		System.out.println("TestCase 8");
	}

	@Test
	public void testCase2() {
		System.out.println("TestCase 2");
	}
	
	@Test
	public void testCase4() {
		System.out.println("TestCase 4");
	}
	
	@Test(groups = {"Sanity"})
	public void testCase50() {
		System.out.println("TestCase 50");
	}
	
	@Test(groups = {"Sanity"})
	public void testCase99() {
		System.out.println("TestCase 99");
	}
	
	@Test(groups = {"Sanity", "Feature1"})
	public void testCase100() {
		System.out.println("TestCase 100");
	}
	
	@Test(groups = {"Sanity"})
	public void testCase10() {
		System.out.println("TestCase 10");
	}
}





