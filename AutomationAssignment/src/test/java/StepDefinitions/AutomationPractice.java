package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.LogIn;
import PageObjects.MyPersonalInformation;
import PageObjects.ProductCheckout;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AutomationPractice {
	
	private WebDriver driver = null;
	String url = "http://automationpractice.com/index.php";
	LogIn login = null;
	
	@Before("@ProductPurchase,@UpdateInformation")
	public void setUp() {
		
		String browser = "chrome";
		
		switch(browser) {
			 case "chrome"  : System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
							  driver = new ChromeDriver();
						 	  break;
			 case "firefox" : System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		 					  driver = new FirefoxDriver();
	 					 	  break;
			 case "ie" : System.setProperty("webdriver.gecko.driver", "Drivers\\IEDriverServer.exe");
		 					  driver = new InternetExplorerDriver();
			 				  break;
		 	 default : System.out.println("Invalid choice of a browser!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	}
	
	@Given("^the url of the application under test$")
	public void the_url_of_the_application_under_test() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}

	@Given("^user is on the website, login with the following credentials$")
	public void user_is_on_the_website_login_with_the_following_credentials(DataTable credential) throws Exception {
	    List credentials = credential.asList(String.class);
	    login = new LogIn(driver);
	    login.clickSignIn();
	    login.enterEmail(String.valueOf(credentials.get(0)));
	    login.enterPassword(String.valueOf(credentials.get(1)));
	    login.clickSignInButton();
	}

	@When("^user is on My Store click on T-Shirts Menu and Order a T-Shirt$")
	public void user_is_on_My_Store_click_on_T_Shirts_Menu_and_Order_a_T_Shirt() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    new ProductCheckout(driver).clickTshirts();
	    new ProductCheckout(driver).addTShirtToCart();
	}

	@Then("^verify order is placed successfully in Order History$")
	public void verify_order_is_placed_successfully_in_Order_History() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(new ProductCheckout(driver).verifyOrder());
	}
	
	@Given("^user is on the website, navigate to My Personal Information Page$")
	public void user_is_on_the_website_go_to_My_Personal_Information_Page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		login = new LogIn(driver);
		login.clickSignIn();
	    login.enterEmail(String.valueOf("johndoe@email.com"));
	    login.enterPassword(String.valueOf("password"));
	    login.clickSignInButton();
	    new MyPersonalInformation(driver).clickOnPersonalInfo();
	    new MyPersonalInformation(driver).updateFirstName();
	}

	@When("^user is on Your Personal Information Page, update First Name$")
	public void user_is_on_Your_Personal_Information_Page_update_First_Name() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		new MyPersonalInformation(driver).updateFirstName();
	}
	
	@After("@ProductPurchase,@UpdateInformation")
	public void tearDown() {
		driver.quit();
	}

}
