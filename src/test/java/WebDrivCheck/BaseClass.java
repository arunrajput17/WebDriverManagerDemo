package WebDrivCheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver =new ThreadLocal<WebDriver>();
	
//	@BeforeClass
	public WebDriver intialz()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		
		
		tdriver.set(driver);
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
		
	}

}
