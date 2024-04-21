package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Workers;

public class HPMaddEmployeeWindow extends Workers{

	@FindBy(xpath = "//label[text()='Employee Full Name']")
	public WebElement employeeFullNameLabel;
	
	@FindBy(id = "first-name-box")
	public WebElement employeeFirstNameField;
	
	@FindBy(id = "middle-name-box")
	public WebElement employeeMiddleNameField;
	
	@FindBy(id = "last-name-box")
	public WebElement employeeLastNameField;
	
	@FindBy(xpath = "//label[text()='Employee Id']")
	public WebElement employeeIdLabel;
	
	@FindBy(xpath = "//label[text()='Location']")
	public WebElement employeeLocationLabel;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/ul")
	public WebElement selectLocationButton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[3]/button[2]")
	public WebElement saveButton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[4]/div/div/span/div")
	public WebElement loginDetailsSlider;
	
	@FindBy(id = "username")
	public WebElement usernameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "confirmPassword")
	public WebElement confirmPasswordField;
	
	public HPMaddEmployeeWindow(){
		PageFactory.initElements(myDriver, this);
	}
}
