package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPersonalInformation {
	
	private WebDriver driver;
	
	By personalInfo = By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span");
	By firstName = By.id("firstname");
	
	public MyPersonalInformation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnPersonalInfo() {
		driver.findElement(personalInfo).click();
	}
	
	public void updateFirstName() {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys("Johnathon");
	}
}
