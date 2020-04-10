package au.com.bunnings.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {
	// Create Browser Reference
	WebDriver driver;

	// Initialize Browser Reference in Constructor
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	// Get reference of I/N Number on WishList Page
	public WebElement getINNumberText() {
		WebElement inNumberText = driver.findElement(By.className("fineline"));
		return inNumberText;
	}

	// Define Explicit wait for WishList Page to Load
	public void waitForWishListPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getINNumberText()));
	}
}
