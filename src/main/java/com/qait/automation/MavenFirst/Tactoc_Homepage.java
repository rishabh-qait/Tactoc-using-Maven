package com.qait.automation.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tactoc_Homepage {
	WebDriver driver;
	WebElement link_Basic_Course;
	
	public Tactoc_Homepage(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public WebElement get_Basic_Course_link() {
		link_Basic_Course =	driver.findElement(By.linkText("Basic Course"));
		return link_Basic_Course;
	}
	

	
	
	

}
