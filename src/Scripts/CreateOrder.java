package Scripts;

import Pages.BaseClass;
import Pages.Context;
import Pages.LandingPage;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateOrder extends BaseClass{
	
	WebDriver driver;
	LandingPage lp1;
	ArrayList<Context> context;
	
	
	@BeforeMethod
	public void preReq() {
		
	driver=invokeBrowser();
    lp1= PageFactory.initElements(driver, LandingPage.class);
    //generating the reports in the format of extent report 
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\repo\\Capegemni\\CapegemniDemo\\test-output\\Reports.html");
	extent.attachReporter(htmlReporter);
    ExtentTest test = extent.createTest("My Test", "Description of my test");
    extenttest.set(test);
    	}
	
	@Test
	public void firstTest() throws InterruptedException {
	
	  lp1.register();
	  BaseClass.logging("succesfully navigated to the registered page");  
      lp1.creatingNewAccount();
      BaseClass.logging("succesfully Registered into the page");
      lp1.addingtoCart();
      BaseClass.logging("succesfully added item into the cart");
	}

	@AfterMethod
	public void closingBrowser() {
		
		driver.quit();
	}
}
