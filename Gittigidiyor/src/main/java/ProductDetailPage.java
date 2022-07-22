import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends WebPage {

	
	By addCardButtonLocator = By.id("add-to-cart-button");
	By radioButton = By.className("a-icon-radio-inactive");
	By productInformationLocator = By.id("productTitle");
	By productPriceLocator = By.xpath("//span[@data-a-color='secondary']");
	By productPriceLocator2 = By.cssSelector(".a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay");
	By backToSearchresults = By.id("breadcrumb-back-link");
	
	ProductDetailPage productDetailPage ;
	static WebDriverWait wait;
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isOnProductDetailPage() {
		return ElementExist(backToSearchresults);
	}
	public Boolean isRadioButtonExist() {
		return driver.findElements(By.className("a-icon-radio-inactive")).isEmpty();
	}

	public void addProductToCard() {
		productDetailPage = new ProductDetailPage(driver);
		
		if ( productDetailPage.isRadioButtonExist()) {
			click(addCardButtonLocator);
			} else {
				click(radioButton);
				wait = new WebDriverWait(driver ,Duration.ofSeconds(3));
				wait.until(ExpectedConditions.visibilityOfElementLocated(addCardButtonLocator));
				click(addCardButtonLocator);
			}
		
		
	}
	
	public void writeToText() throws IOException {
		productDetailPage = new ProductDetailPage(driver);
		if ( productDetailPage.isRadioButtonExist()) {
			String productInformation = findElement(productInformationLocator).getText();
			String priceInformation = findElement(productPriceLocator2).getText();
			
			File output = new File("productDetail.txt");
			FileWriter fileWriter = new FileWriter(output);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.write(productInformation + " ----> " + priceInformation);
			printWriter.close();
		} else {
			
			String productInformation = findElement(productInformationLocator).getText();
			String priceInformation = findElement(productPriceLocator).getText();
			
			File output = new File("productDetail.txt");
			FileWriter fileWriter = new FileWriter(output);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.write(productInformation + " ----> " + priceInformation);
			printWriter.close();
		}
	}

}
