package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.PropertiesReader;
import utils.Workers;

import pages.HRMdashboard;
import pages.HRMlogin;


public class LoginTest extends Workers{
	
	@Test
	public void loginTest() {
		
		HRMlogin login = new HRMlogin();
		HRMdashboard dashboard = new HRMdashboard();
		
		test.info("Entering valid login credentials.");
		
		sendText(login.usernameField, PropertiesReader.getProps("username"));
		sendText(login.passwordField, PropertiesReader.getProps("password"));
		
		click(login.loginButton);
		
		test.info("Verifying that user is logged in.");
		
		String expectedemployee = "Jacqueline White";
		Assert.assertEquals(expectedemployee, dashboard.accountName.getText(), "Names do not match.");
	}
		
	
}
