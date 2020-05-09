package Tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GoogleSearch {
	WebDriver driver;
	
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
		
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void sendText() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("TestNG");
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void clickSearchButton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).submit();
		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
