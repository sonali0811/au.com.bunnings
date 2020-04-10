package au.com.bunnings.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	// Create Browser Reference
	WebDriver driver;

	// Initialize Browser Reference in Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Get reference of HomePage Pop-up Close Button
	public WebElement getPopupCloseButton() {
		WebElement popupCloseButton = driver.findElement(By.xpath("//div[@class='header-close']/a"));
		return popupCloseButton;
	}

	// Get reference of Search Text Box
	public WebElement getSearchboxTextbox() {
		WebElement searchBox = driver.findElement(By.cssSelector("input[data-page='/search']"));
		return searchBox;
	}

	// Get reference of Search Button
	public WebElement getSearchButton() {
		WebElement searchButton = driver.findElement(By.className("search-container_btn-submit"));
		return searchButton;
	}

	// Define Explicit wait for HomePage to Load
	public void waitForHomePageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getPopupCloseButton()));
		wait.until(ExpectedConditions.visibilityOf(getSearchboxTextbox()));
		wait.until(ExpectedConditions.visibilityOf(getSearchButton()));
	}
}
