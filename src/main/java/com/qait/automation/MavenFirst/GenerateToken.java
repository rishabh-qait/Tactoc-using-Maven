package com.qait.automation.MavenFirst;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class GenerateToken {
	WebDriver driver;
	WebElement proceedaftercookieadd;
	WebDriverWait wait;
	
	public GenerateToken(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void  generateTokenAndAddCookie()  {
		 driver.get("http://10.0.1.86/tatoc/basic/cookie");
		
		driver.findElement(By.linkText("Generate Token")).click();

	
		String cookietext = driver.findElement(By.id("token")).getText();
		String[] splited = cookietext.split("\\s+");

		Cookie token1 = new Cookie("Token", splited[1]);

		driver.manage().addCookie(token1);
		
	}
	public void  generateTokenAndNotAddCookie()  {
		 driver.get("http://10.0.1.86/tatoc/basic/cookie");
		
		driver.findElement(By.linkText("Generate Token")).click();

	
		String cookietext = driver.findElement(By.id("token")).getText();
		String[] splited = cookietext.split("\\s+");

		Cookie token1 = new Cookie("Token", splited[1]);

		
		
	}
	public WebElement get_Proceed_Link() {
		WebElement proceedlink = driver.findElement(By.linkText("Proceed"));
		return proceedlink;
	}

}
