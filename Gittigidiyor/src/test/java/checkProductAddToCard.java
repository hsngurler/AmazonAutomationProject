import java.io.IOException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.junit.Test;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class checkProductAddToCard extends AllTests {

	NavigationPage navigationPage ;
	ProductListPage productListPage ;
	ProductDetailPage productDetailPage ;
	CardPage cardPage ;
	
	public static String price1;
	public static String price2;
	By productPriceLocator = By.xpath("//span[@data-a-color='secondary']");
	By productPriceLocator2 = By.cssSelector(".a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay");
	By priceOnCard = By.cssSelector(".a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold");
	
	@Test
	public void stage1_searchProduct() {
		
		navigationPage = new NavigationPage(driver);
		navigationPage.searchBox.search("bilgisayar");
		productListPage = new ProductListPage(driver);
		Assert.assertTrue("Not on Product List Page" , productListPage.isOnProductPage());
		
	}
	
	
	@Test
	public void stage2_SecondPage() {
		
		productListPage = new ProductListPage(driver);
		productListPage.goSecondPage();
		
		Assert.assertTrue("Not on second Product List Page" , productListPage.isOnSecondProductPage());
		
	}
	
	
	@Test
	public void stage3_selectProduct() {
		
		int random = (int)(Math.random()*(4)+1)-1;
		productListPage = new ProductListPage(driver);
		productListPage.selectRandomProduct(random);
		
		productDetailPage = new ProductDetailPage(driver);
		
		Assert.assertTrue("Not on Product Detail Page" , productDetailPage.isOnProductDetailPage());
		
	}
	
	@Test
	public void stage4_writeProductToTextFile() throws IOException {
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.writeToText();
		if ( productDetailPage.isRadioButtonExist()) {
			String price1 = driver.findElement(productPriceLocator2).getText();
			} else {
				String price1 = driver.findElement(productPriceLocator).getText();
			}
		
		
	}
	
	
	
	@Test
	public void stage5_addToCard() {
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.addProductToCard();
		
	}
	
	
	@Test
	public void stage6_goCardPage() {
		
		navigationPage = new NavigationPage(driver);
		navigationPage.clickCardPageContainer();
		String price2 = driver.findElement(priceOnCard).getText();
		
	}
	
	@Test
	public void stage7_checkPrices() {
		
		Assert.assertEquals(price1, price2);
		
	}
	
	@Test
	public void stage8_doubleTheProduct() {
		
		cardPage = new CardPage(driver);
		cardPage.doubleTheProduct();
		cardPage.checkProductDoubled();
		
	}
	
	@Test
	public void stage9_deleteTheProduct() {
		
		cardPage = new CardPage(driver);
		cardPage.deleteTheProduct();
		cardPage.checkProductDeleted();
		
	}
	
		
}
