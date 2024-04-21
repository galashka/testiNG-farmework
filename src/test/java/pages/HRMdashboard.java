package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Workers;

public class HRMdashboard extends Workers{

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pimMenu;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div[5]/ul/li[2]/div/ul/li[2]")
	public WebElement employeeList;
	
	@FindBy(xpath = "//*[@id=\"account-name\"]")
	public WebElement accountName;
	
	
	public HRMdashboard(){
		PageFactory.initElements(myDriver, this);
	}
}
