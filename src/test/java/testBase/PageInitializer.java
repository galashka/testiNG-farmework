package testBase;

import pages.HPMaddEmployeeWindow;
import pages.HRMdashboard;
import pages.HRMlogin;

public class PageInitializer {

	public static HRMlogin login;
	public static HRMdashboard dashboard;
	public static HPMaddEmployeeWindow addEmployee;
	
	public static void initializePage() {
		
		login = new HRMlogin();
		dashboard = new HRMdashboard();
		addEmployee = new HPMaddEmployeeWindow();
	}
	
	
	
}
