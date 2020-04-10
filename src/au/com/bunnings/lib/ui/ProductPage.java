package au.com.bunnings.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	// Create Browser Reference
	WebDriver driver;

	// Initialize Browser Reference in Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Get reference of WishList Button
	public WebElement getWishListButton() {
		WebElement WishListButton = driver.findElement(By.xpath("//button[text()='Save to Wishlist']"));
		return WishListButton;
	}

	// Get reference of WishList Page Link
	public WebElement getWishListPageLink() {
		WebElement WishListPageLink = driver.findElement(By.linkText("wishlist"));
		return WishListPageLink;
	}

	// Get reference of I/N Number on Product Details Page
	public WebElement getINNumberText() {
		WebElement inNumberText = driver.findElement(By.xpath("//div[@class='product-detail__ratings']/span"));
		return inNumberText;
	}

	// Define Explicit wait for "Add to WishList Button" to enable on Product Details Page
	public void waitForWishListButtonProductPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getWishListButton()));
	}

	// Define Explicit wait for "WishList Page Link" to enable on Product Details Page
	public void waitForWishListPageLinkProductPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getWishListPageLink()));

	}
}
