package com.qait.automation.MavenFirst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class DragAndDrop {
	WebDriver driver;
	WebElement from;
	WebElement to;
	WebElement proceedlinkfordrag;
	public DragAndDrop(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement getdragelement() {
		
		 from = driver.findElement(By.id("dragbox"));
		 return from;
	}
	public WebElement getdropelement() {
		
		to = driver.findElement(By.id("dropbox"));
		 return to;
	}
	
	
	public void dragAndDrop(WebElement from , WebElement to) 
	{
		this.from=from;
		this.to=to;
		
		//driver.get("http://10.0.1.86/tatoc/basic/drag");
		
	 
		Actions builder = new Actions(driver);
		Actions draganddrop = builder.clickAndHold(from).moveToElement(to).release(to);
		draganddrop.perform();
		//proceedlinkfordrag=driver.findElement(By.linkText("Proceed"));
        //return proceedlinkfordrag;
		
	}
	public WebElement get_Proceed_Link() {
		WebElement proceedlink = driver.findElement(By.linkText("Proceed"));
		return proceedlink;
	}

}
