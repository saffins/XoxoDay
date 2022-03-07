package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.UtilMethods;

public class AddItem {

	WebDriver driver;
	WebDriverWait driverWait;
	UtilMethods methods;

	public AddItem(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, 30);
		methods = new UtilMethods(driver);
	}

	public void addItemAndCheckout() {

		// click on item to be added
		methods.clickOnElement(
				By.xpath("//*[contains(@id,'dataSection')]/div[1]/div[1]//div[@class='entityCardContentWrapper']/a"));

		// select quantity as 2
		methods.selectByText(driver.findElement(By.xpath("(//*[@class='gv-dropdown'])[2]/select")), "2");
		

		
		// click on buy now
		methods.clickOnElement(By.xpath("//*[text()='Buy Now']"));

	}

	public void AddItemWithQuantityAdditionButton() {

		// increase the quantity by clicking on addition button
		methods.clickOnElement(By.xpath("//*[@class='addedQtyInput']//button[2]"));
		
		 
		// click on buy now
		methods.clickOnElement(By.xpath("//*[text()='Buy Now']"));

	}

}
