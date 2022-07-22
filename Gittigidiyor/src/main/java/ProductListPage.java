import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage extends WebPage {

	
	By shipping_option = By.id("p_n_free_shipping_eligible-title");
	By productCardLocator = By.className("sg-col-4-of-20");
	By secondPageLocator = By.xpath("//a[@aria-label='2 sayfasına git']");
	By previousPageLocator = By.cssSelector(".s-pagination-item.s-pagination-previous.s-pagination-button.s-pagination-separator");
	By addToBasketButtonLocator = By.className("iRsyUX");
	static WebDriverWait wait;
	
	public ProductListPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isOnProductPage() {
		return ElementExist(shipping_option);

	}
	
	public void goSecondPage() {
		findElement(secondPageLocator).click();

	}
	public Boolean isOnSecondProductPage() {
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(previousPageLocator));
		
		return ElementExist(previousPageLocator);
		
	}

	
	public void selectFirstProduct() {

		findElement(productCardLocator).click();
		
	}
	
	
	public void selectRandomProduct(int i) {
		
		/*Actions action = new Actions(driver);
		action.moveToElement(findElement(productCardLocator)).click().build().perform();
		click(productCardLocator);*/
		findElementList(productCardLocator).get(i).click();
	}

}
