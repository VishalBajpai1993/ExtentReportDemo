package autopractise.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExternalReportsDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void config() {
		
		//ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		// Create ExtentReports Object
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vishal Bajpai");


	}

	
@Test
public void  intialDemo() {
	extent.createTest("Initial Demo"); // It will be getting update at some frequency by the methods
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishal\\eclipse-workspace\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com");
	System.out.println(driver.getTitle());
	extent.flush(); // Mandotry at the end
}

}
