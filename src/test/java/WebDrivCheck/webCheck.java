package WebDrivCheck;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webCheck extends BaseClass{
	
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp()
	{
////		WebDriverManager.chromedriver().setup();
//		
////		//To use particular version of browser only
//////	WebDriverManager.chromedriver().browserVersion("85.0.4183.87").setup();
//		
////		//To get the current version of driver
////		System.out.println("Current version of chrome is : "+WebDriverManager.chromedriver().getDownloadedDriverVersion());
//		
//		
////		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
//		
//		driver = new ChromeDriver();
//		
		BaseClass objbs = new BaseClass();
		driver = objbs.intialz();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("browser opened");
		driver.get("http://demo.nopcommerce.com/");
		System.out.println("site opened");
		
	}
	
	
	@Test(priority=1, description="Verify Logo presence on Home Page TestNG annotation")
	public void logoPresence()
	{
		Boolean status = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	
	@Test(priority=2)
	public void loginTest()
	{
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("Jamie");
		driver.findElement(By.id("Password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		Assert.assertEquals(driver.getTitle(), "noCommerce demo store");
		
	}
	
	
	@Test(priority=3, description="Verify Registration form TestNG Test")
	public void registrationTest()
	{
		
		throw new SkipException("Skipping this test");
				
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	

}
