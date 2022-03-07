package apptest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HomePage.AddItem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XoxoDayHomeTest {

	WebDriver driver = null;
	AddItem addItem = null;

	@BeforeTest
	public void setup() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stores.xoxoday.com/marketplace/vouchers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void AddItemWithQuantityDropdown() {

		addItem = new AddItem(driver);
		addItem.addItemAndCheckout();

		String totalVal = driver.findElement(By.xpath("//*[contains(@class,'totalValue')]")).getText();

		// Verifying if total value in the end of checkout page is found as expected or
		// not
		Assert.assertEquals(totalVal, "1,798.00");

	}

	@Test
	public void AddItemWithQuantityAdditionButton() {

		driver.navigate().back();
		addItem = new AddItem(driver);

		addItem.AddItemWithQuantityAdditionButton();

		String totalVal = driver.findElement(By.xpath("//*[contains(@class,'totalValue')]")).getText();

		// Verifying if total value in the end of checkout page is found as expected or
		// not
		Assert.assertEquals(totalVal, "5,394.00");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
