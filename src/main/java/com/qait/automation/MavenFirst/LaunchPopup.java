package com.qait.automation.MavenFirst;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPopup {
	WebDriver driver;
	WebElement proceedaftersubmitting;
	WebDriverWait wait;
	public LaunchPopup(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public void submitText(String text) {

		driver.findElement(By.linkText("Launch Popup Window")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
        WebElement nm = driver.findElement(By.id("name"));
		nm.click();
		nm.sendKeys(text);
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(parentWindowHandler);
       // proceedaftersubmitting = driver.findElement(By.linkText("Proceed"));
        //return 	 proceedaftersubmitting ;
	}
	public WebElement get_Proceed_Link() {
		WebElement proceedlink = driver.findElement(By.linkText("Proceed"));
		return proceedlink;
	}
	

}
