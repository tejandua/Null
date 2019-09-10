package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	
	private WebDriver driver;
	
	By signIn = By.className("login");
	By email = By.id("email");
	By pwd = By.id("passwd");
	By signInButton = By.id("SubmitLogin"); 
	
	public LogIn(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}
	
	public void enterEmail(String emailId) {
		driver.findElement(this.email).sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
	
}
