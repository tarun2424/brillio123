package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossB {
	
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
 	     driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();;
			    driver=new ChromeDriver();
		}
		else {
			throw new Exception("Browser not correct");
		}
	}

	
	@Test
	public void demo() throws InterruptedException
	{
		
	    driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	    driver.findElement(By.name("username")).sendKeys("tarun");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Abcd@1234");
	    Thread.sleep(2000);
	    driver.findElement(By.name("signon")).click();

		}
	}
