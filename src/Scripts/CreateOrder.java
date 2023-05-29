package Scripts;

import Pages.BaseClass;
import Pages.LandingPage;
import java.util.ArrayList;
import javax.naming.Context;
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
	ExtentReports extent;
	ExtentTest test;
	
	
	
	@BeforeMethod
	public void preReq() {
		
	driver=invokeBrowser();
    lp1= PageFactory.initElements(driver, LandingPage.class);
    
       // Setting up Extent Reports
 		extent = new ExtentReports();
 		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Extent_Reports.html");
 		extent.attachReporter(htmlReporter);
 		test = extent.createTest("Create Order Test", "Verifying order creation");
 		extenttest.set(test);

    	}
	
	@Test
	public void createOrderTest() throws InterruptedException {
		// Register Test Step
		lp1.register();
		BaseClass.logging("Successfully navigated to the registered page");
		test.log(Status.PASS, "Successfully navigated to the registered page");
		
		// Creating New Account Test Step
		lp1.creatingNewAccount();
		BaseClass.logging("Successfully registered into the page");
		test.log(Status.PASS, "Successfully registered into the page");
		
		// Adding to Cart Test Step
	   lp1.addingtoCart();
		BaseClass.logging("verifying an item added into the cart");
		test.log(Status.FAIL, "Just to check in report - Failed to add item into the cart");
		
		//confirm order
		lp1.confirmOrder();
		BaseClass.logging("Successfully placed an order");
		test.log(Status.PASS, "succesfully places an order");
	}
	
	@AfterMethod
	public void closingBrowser() {
		
		driver.quit();
	}
}
