import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {

	WebDriver driver;
	
	public WebPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public List<WebElement> findElementList(By locator) {
		return driver.findElements(locator);
		
	}
	
	
	public void click(By locator) {
		findElement(locator).click();
		
	}
	
		
	public void type(By locator, String text) {
		findElement(locator).sendKeys(text);
				
	}
	
	public Boolean ElementExist(By locator) {
		return findElement(locator).isDisplayed();
		
	}
	
	
	public Boolean ElementEnabled(By locator) {
		return findElement(locator).isEnabled();
		
	}
	
}
