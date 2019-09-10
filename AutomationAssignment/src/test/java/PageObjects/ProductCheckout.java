package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCheckout {
	
	private WebDriver driver;
	public String ordRef = "";
	
	By tshirts = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	By tshirt = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
	By addToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	By proceedToCheckout = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
	By proceedSummary = By.xpath("//*[@id='center_column']/p[2]/a[1]/span");
	By proceedAddress = By.xpath("//*[@id='center_column']/form/p/button/span");
	By proceedShipping = By.xpath("//*[@id='form']/p/button/span");
	By tnc = By.id("cgv");
	By paymentMethod = By.cssSelector("a[class='bankwire']");
	By confirmOrder = By.xpath("//*[@id='cart_navigation']/button/span");
	By backToOrders = By.xpath("//*[@id='center_column']/p/a");
	By orderReference = By.xpath("//*[@id='center_column']/div");
	By orderHistoryReference = By.xpath("//*[@id='order-list']/tbody/tr/td[1]/a");
	
	public ProductCheckout(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickTshirts() {
		driver.findElement(tshirts).click();
	}
	
	public void addTShirtToCart() {
		Actions actions = new Actions(driver);
		WebElement shirt = driver.findElement(tshirt);
		Action mouseOver = actions.moveToElement(shirt).build();
		mouseOver.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCart)));
		
		driver.findElement(addToCart).click();
		driver.findElement(proceedToCheckout).click();
		driver.findElement(proceedSummary).click();
		driver.findElement(proceedAddress).click();
		driver.findElement(tnc).click();
		driver.findElement(proceedShipping).click();
		driver.findElement(paymentMethod).click();
		driver.findElement(confirmOrder).click();
		driver.findElement(backToOrders).click();
	}
	
	public boolean verifyOrder() throws Exception {
		Thread.sleep(1000);
		ordRef = driver.findElement(orderReference).getText();
//		System.out.println("~"+ordRef);
//		System.out.println("~~"+driver.findElement(orderHistoryReference).getText());
		if(ordRef.contains(driver.findElement(orderHistoryReference).getText())){
			return true;
		}
		return false;
	}
}
