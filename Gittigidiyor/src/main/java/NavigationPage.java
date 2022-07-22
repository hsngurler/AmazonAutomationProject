import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends WebPage {

	SearchBox searchBox;
	By cardContainerLocator = By.id("nav-cart");
	
	
	
	public NavigationPage(WebDriver driver) {
		super(driver);
		searchBox =  new SearchBox(driver);
		
	}
	
	
	public SearchBox searchBox() {
		return this.searchBox;
	}

	public void clickCardPageContainer() {
		click(cardContainerLocator);
	}
	
	
	
}
