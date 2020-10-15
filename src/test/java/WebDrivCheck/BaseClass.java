package WebDrivCheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver =new ThreadLocal<WebDriver>();
	
//	@BeforeClass
	public WebDriver intialz()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		WebDriverManager.iedriver().setup();
//		driver = new InternetExplorerDriver();
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		
		
		tdriver.set(driver);
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
		
	}

}
