package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilMethods {

	WebDriver driver;
	WebDriverWait driverWait;

	public UtilMethods(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, 30);

	}

	public void typeText(By by, String text) {

		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);

	}

	public void clickOnElementByJS(By by) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}

	public void selectByText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void clickOnElement(By by) {

		driver.findElement(by).click();
	}

	public void waitForLoad(WebElement element) {
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
