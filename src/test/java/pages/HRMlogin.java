package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Workers;

public class HRMlogin extends Workers{

	@FindBy(id="txtUsername")
	public WebElement usernameField;
	
	@FindBy(id="txtPassword")
	public WebElement passwordField;

	@FindBy(id="txtPassword-error")
	public WebElement errorMessage;
	
	@FindBy(xpath="/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")
	public WebElement loginButton;
	
	public HRMlogin(){
		
		PageFactory.initElements(myDriver, this);
	}
}
