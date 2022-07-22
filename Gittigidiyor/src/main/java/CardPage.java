import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage extends WebPage {
	
	By productUpdate = By.className("a-dropdown-prompt");
	By deleteProductLocator = By.cssSelector(".a-size-small.sc-action-delete");
	
	static WebDriverWait wait;
	
	
	public CardPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	public void doubleTheProduct() {
		
		Actions action = new Actions(driver);
		action.moveToElement(findElement(productUpdate)).click().build().perform();
		click(By.id("quantity_2"));
		
	}

	
	public void checkProductDoubled() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String doubleProduct = findElement(By.id("sc-subtotal-label-buybox")).getText();
		Assert.assertEquals(doubleProduct, "Ara toplam (2 ürün):");
		
	}
	
	
	public void deleteTheProduct() {
		
		click(deleteProductLocator);
		
	}

	public void checkProductDeleted() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String deletedProductLocator = findElement(By.id("sc-subtotal-label-activecart")).getText();
		Assert.assertEquals(deletedProductLocator, "Ara toplam (0 ürün):");
		
	}
	
}
