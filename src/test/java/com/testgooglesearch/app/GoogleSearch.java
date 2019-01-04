package com.testgooglesearch.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {

	@BeforeTest
	public void setProperties() {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//shant//Desktop//chromedriver_win32//chromedriver.exe");
	}

	@Test
	public void testGoogleSearch() {

		

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("test automation is awesome\n"); 

		System.out.println("Page title is: " + driver.getTitle());

		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("test automation is awesome");
			}
		});

		// Should see: "test automation is awesome - Google Search"
		System.out.println("Page title is: " + driver.getTitle());
		// Close the browser
		driver.quit();

	}

	@AfterTest()
	public void close() {

	}
}
