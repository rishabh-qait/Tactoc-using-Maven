package com.qait.automation.MavenFirst;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenTest {

	WebDriver driver;
	String parentWindowHandler;
	

	@Test
	public void Homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86//tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/grid/gate", driver.getCurrentUrl());
	}

	@Test ( dependsOnMethods = { "Homepage" })
	public void chooseGreen()  {
		WebElement we2 = driver.findElement(By.className("greenbox"));
		we2.click();
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/frame/dungeon", driver.getCurrentUrl());

		// Assert.assertEquals("http://10.0.1.86/tatoc/basic/grid/gate",
		// driver.getCurrentUrl(),"Didn't navigate to correct webpage");
	}

	@Test ( dependsOnMethods = { "chooseGreen" })
	public void waitTimeAndColorMatch() {
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		WebElement main = driver.findElement(By.id("answer"));
		Assert.assertTrue(main.isDisplayed());
		String expected = main.getAttribute("class");
		System.out.println(expected);

		Boolean check = true;
		// @Test
		// public void clickRepaint() {
		while (check) {
			driver.findElement(By.linkText("Repaint Box 2")).click();

			WebElement child = driver.findElement(By.id("child"));
			driver.switchTo().frame(child);
			String actual = driver.findElement(By.id("answer")).getAttribute("class");
			System.out.println(actual);
			if (actual.equals(expected)) {
				check = false;

			}
			driver.switchTo().parentFrame();

		}

		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/drag", driver.getCurrentUrl());

	}

	@Test  ( dependsOnMethods = { "waitTimeAndColorMatch" })
	public void dragAndDrop() {
		driver.get("http://10.0.1.86/tatoc/basic/drag");
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		Actions builder = new Actions(driver);
		Actions draganddrop = builder.clickAndHold(from).moveToElement(to).release(to);
		draganddrop.perform();
		driver.findElement(By.linkText("Proceed")).click();

		Assert.assertEquals("http://10.0.1.86/tatoc/basic/windows", driver.getCurrentUrl());

	}

	@Test  ( dependsOnMethods = { "dragAndDrop" })
	public void handleWindows() {

		driver.findElement(By.linkText("Launch Popup Window")).click();

		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
        WebElement nm = driver.findElement(By.id("name"));
		nm.click();
		nm.sendKeys("RISHABH JAIN");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(parentWindowHandler);
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/windows#", driver.getCurrentUrl());
		driver.findElement(By.linkText("Proceed")).click();
	}

	 @Test ( dependsOnMethods = { "handleWindows" })
	public void  generateTokenAndAddCookie() throws InterruptedException {
		 driver.get("http://10.0.1.86/tatoc/basic/cookie");
		
		driver.findElement(By.linkText("Generate Token")).click();

		// public void generateAndAddCookie() {
		String cookietext = driver.findElement(By.id("token")).getText();
		String[] splited = cookietext.split("\\s+");

		Cookie token1 = new Cookie("Token", splited[1]);

		driver.manage().addCookie(token1);
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/cookie#", driver.getCurrentUrl());
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(2000);
		driver.close();

	}
}