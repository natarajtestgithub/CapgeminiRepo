package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LandingPage extends BaseClass{
	String linkValue;
		
	public LandingPage(WebDriver driver) {
		super.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	


	@FindBy(xpath="//ul[@id='customer_menu_top']/li/a")
	static
	WebElement login;
	
	@FindBy(xpath="//Button[@title='Continue']")
	static
	WebElement continueButton;
	
	@FindBy(id="AccountFrm_firstname")
	static
	WebElement firstName;
	
	@FindBy(id="AccountFrm_lastname")
	static
	WebElement lastName;
	
	@FindBy(id="AccountFrm_agree")
	static
	WebElement privacyCheckbox;
	

	@FindBy(id="AccountFrm_email")
	WebElement email;
	
	@FindBy(name="telephone")
	static
	WebElement telephone;
	
	@FindBy(name="fax")
	static
	WebElement fax;
	
	@FindBy(name="address_1")
	static
	WebElement address1;
	
	@FindBy(name="city")
	static
	WebElement city;
	
    @FindBy(name="postcode")
	static
	WebElement zipcode;
	
	@FindBy(name="loginname")
	static
	WebElement loginname;
	
	@FindBy(name="password")
	static
	WebElement password;
	
	@FindBy(name="confirm")
	static
	WebElement cnfmPwd;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	static
	WebElement checkBox;
	
	@FindBy(xpath="//span[@class='maintext']")
	static
	WebElement regeisterPageName;
	
	@FindBy(xpath="//input[@name='filter_keyword']")
	static
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='thumbnails grid row list-inline']/div/div[2]/div[3]/a")
	static
	List<WebElement> items;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(@href, 'checkout/cart')]")
	static
	WebElement addToCart;
	
	
	@FindBy(xpath="//a[@id='cart_checkout1']")
	static
	WebElement checkOut;
	
	
	@FindBy(xpath="//a[@class='checkout_heading']")
	static
	WebElement itemvalidate;
	
	@FindBy(xpath="//button[@id='checkout_btn']")
	static
	WebElement cnfmOrder;
	
	
	@FindBy(xpath="//span[contains(text(),' Your Order Has Been Processed!')]")
	static
	WebElement validatesuccessmsg;
		
	
	
	public static void register() throws InterruptedException {
		
		//element.sendKeys(context.firstName);;
		Thread.sleep(5000);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		login.click();
		Thread.sleep(2000);
		continueButton.click();
		
		String accountPageName=regeisterPageName.getText();
		//Assert.assertEquals("Account Login",accountPageName);
		System.out.println("inside register");
	}
	
	public void creatingNewAccount() throws InterruptedException
	{
		String pageName=regeisterPageName.getText();
		System.out.println(pageName);
		
	//	Assert.assertEquals("",pageName);
		//logging("Entering the details for registration");
		firstName.sendKeys("FirstName",Keys.TAB);
		//logging("Entering first name as FirstName");
		lastName.sendKeys("cap last",Keys.TAB);
		email.sendKeys("testcap@gmail.com",Keys.TAB);
		telephone.sendKeys("1234566",Keys.TAB);
		fax.sendKeys("467",Keys.TAB);
		address1.sendKeys("address1",Keys.TAB);
		city.sendKeys("Bengaluru",Keys.TAB);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("India");
		Thread.sleep(10000);
		Select state = new Select(driver.findElement(By.name("zone_id")));
		state.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(2000);
		zipcode.sendKeys("560045",Keys.TAB);
		loginname.sendKeys("Cap1234",Keys.TAB);
		password.sendKeys("Cap@123",Keys.TAB);
		cnfmPwd.sendKeys("Cap@123",Keys.TAB);
		privacyCheckbox.click();
		Thread.sleep(1000);
		continueButton.click();
		Thread.sleep(2000);
		continueButton.click();
	}
	

	public void addingtoCart() throws InterruptedException
	{
		 //adding item to the cart
   searchButton.sendKeys("Men");
   searchButton.click();
   Thread.sleep(1000);
    for(WebElement item :items)
    {
    	if(item.getAttribute("class").contains("Add to Cart"))
    	{
    		
    		item.click();
    		String linkValue = item.getAttribute("href");
            System.out.println("Link Value: " + linkValue);
    	}
    	break;
    	    	
    }
    addToCart.click();
    Thread.sleep(8000);
    checkOut.click();
    Thread.sleep(8000);
	}
	
	public void confirmOrder() throws InterruptedException
	{
		String linkValue1 = itemvalidate.getAttribute("href");
        System.out.println("Link Value: " + linkValue);
		Assert.assertEquals(linkValue1, linkValue);
		cnfmOrder.click();
		Thread.sleep(1000);
		String ordermessage= validatesuccessmsg.getAttribute("innerText");
		assertEquals(ordermessage, "Your Order Has Been Processed!");
	}
	

}
