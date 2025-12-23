package anudip.assignments;

import org.testng.annotations.Test;

public class TestBank {
	
	@Test(priority=1)
	public void openapp() {
		System.out.println("Application Opened...");
	}
	
	@Test(priority=2, dependsOnMethods = "openapp")
	public void login() {
		
		System.out.println("Login Sucessfully");
		
	}
	
	@Test(priority=3, enabled =false)
	public void checkbalance() {
		System.out.println("Balance = ₹50,000");
	}
	
	@Test(priority=4, dependsOnMethods = "login")
	public void transferMoney() {
		System.out.println("Money Transfered Sucessfully");
	}
	
	@Test(priority=5)
	public void logout() {
		System.out.println("Logout sucessfully");
	}
	
	

}
