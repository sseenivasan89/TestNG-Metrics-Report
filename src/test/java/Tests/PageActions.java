package Tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PageActions {
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
		driver.get("https://www.selenium.dev/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void clickOnTabs() throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertEquals(title, "SeleniumHQ Browser Automation");
		driver.findElement(By.xpath("//a[contains(text(),'Downloads')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Support')]")).click();
	}

	@Test(priority = 2)
	public void searchOnSomething() throws InterruptedException {
		driver.findElement(By.cssSelector("[name='search']")).sendKeys("wait");
		driver.findElement(By.xpath("//img[@class='search-icon']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
