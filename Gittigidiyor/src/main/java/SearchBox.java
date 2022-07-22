import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends WebPage{

	
	By searchBoxLocator = By.id("twotabsearchtextbox");
	By searchButtonLocator = By.id("nav-search-submit-text");
	
	public SearchBox(WebDriver driver) {
		super(driver);
	}

	public void search(String text) {
		type(searchBoxLocator, text);
		click(searchButtonLocator);
	}
	
	
}
