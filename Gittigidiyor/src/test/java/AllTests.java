import java.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AllTests {
		
	
	static NavigationPage navigationPage ;
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	
	@BeforeClass
	
	public static void setUp() {
		
		By cookiesAcceptButton = By.id("a-autoid-0");
		
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com.tr/");
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptButton));
		driver.findElement(cookiesAcceptButton).click();
	}
	
	
	/*@AfterClass
	
	public static void tearDown() {
		
		driver.quit();
		
	}*/
	

}
