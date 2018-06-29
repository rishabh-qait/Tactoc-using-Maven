package com.qait.automation.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tactoc_Grid {
	WebDriver driver;
	WebElement greenboxelement;
	
	public Tactoc_Grid(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement get_Greenbox() {
		greenboxelement =	driver.findElement(By.className("greenbox"));
		return greenboxelement;
	}

}
