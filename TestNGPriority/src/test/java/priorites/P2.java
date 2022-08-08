package priorites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P2 
{
	WebDriver driver;
	 
	@BeforeMethod
	public void enterURL() {
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/mS/Documents/MonaQAjars/WebDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	public void login() {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	
	@Test(priority = 3)
	public void getTiltle(){
		driver.getTitle();
	}
	
	@Test(priority = 4)
	public void getLogo() {
		boolean b = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
		System.out.println(b);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	
	

}
