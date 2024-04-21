package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;
import utils.PropertiesReader;

public class BrowserManager {
	
	public static WebDriver myDriver;
	/**
	 * 
	 */
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		
		PropertiesReader.readProps(Constants.PROPERTIES_PATH);
		
		String myBrowser = PropertiesReader.getProps("browser");
		
		switch(myBrowser) {
		
		  case "chrome":
			  
			    ChromeDriverService service = ChromeDriverService.createDefaultService();
			    ChromeOptions options = new ChromeOptions();
				
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--allow-insecure-localhost");
				options.addArguments("--allow-running-insecure-content");
				options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				
				myDriver = new ChromeDriver(service, options);
				
			  break;
			  
		  case "firefox":
			  myDriver = new FirefoxDriver();
			  break;
		}
		
		myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		myDriver.manage().window().maximize();
		myDriver.navigate().to(PropertiesReader.getProps("url"));
	}
	
	/**
	 * 
	 */
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		
		if(myDriver != null) {
			myDriver.quit();
		}
	}
	
	public static ExtentSparkReporter sparkReport;
	public static ExtentTest test;
	public static ExtentReports report;
	
	/**
	 * 
	 */
	@BeforeTest(alwaysRun = true)
	public void generatereport() {
		
		sparkReport = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
		sparkReport.config().setDocumentTitle("My test title.");
		sparkReport.config().setReportName("My reportname.");
		sparkReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}
	
	/**
	 * 
	 */
	@AfterTest(alwaysRun = true)
	public void writeReport() {
		
		report.flush();
	}
	
}
