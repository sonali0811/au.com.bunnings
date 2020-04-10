package au.com.bunnings.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	// Create Browser Reference
	WebDriver driver;

	// Initialize Browser Reference in Constructor
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	// Get reference of First Product from Search Result List
	public WebElement getsearchProductLink() {
		WebElement searchProductLink = driver.findElement(By.xpath("//section[@class='product-list']/article[1]/a[1]"));
		return searchProductLink;
	}

	// Define Explicit wait for Search Result Page to Load
	public void waitForSearchResultPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getsearchProductLink()));
	}
}
