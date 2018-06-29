package com.qait.automation.MavenFirst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;

public class Tactoc_Colormatch {
	//Tactoc_Colormatch obj;
	WebDriver driver;
	WebElement proceedlink;
	WebElement repaintlink;
	WebDriverWait wait;
	String expected1;
	//String expected2=obj.get_Class_Of_Box_1();
	
	public Tactoc_Colormatch(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	
	
	public  String get_Class_Of_Box_1() 
	{
		
		
		
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		WebElement main = driver.findElement(By.id("answer"));
		 expected1 = main.getAttribute("class");
		System.out.println(expected1);
	return expected1;
		
	}
	public  String get_Diff_Class_Of_Box_2() 
	{
		
		String actual1="";
		//String expected2=obj.get_Class_Of_Box_1();
		WebElement child;
		/*String actual1;
		WebElement child;
		
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		WebElement main = driver.findElement(By.id("answer"));
		String expected1 = main.getAttribute("class");
		System.out.println(expected1);*/
		
		Boolean check = true;
		while (check) 
		{
	        driver.findElement(By.linkText("Repaint Box 2")).click();
			 child = driver.findElement(By.id("child"));
			driver.switchTo().frame(child);
			 actual1 = driver.findElement(By.id("answer")).getAttribute("class");
			System.out.println(actual1);
			if( !(actual1.equals(expected1)))
			    {
				check = false;
				}
			driver.switchTo().parentFrame();

		}
       // proceedlink= driver.findElement(By.linkText("Proceed"));
		return actual1;
		
		
		
	}
	
	
	 
	
	public  String get_Class_Of_Box_2_Sameasbox1() {
		
		
		String actual1="";
		//String expected2=obj.get_Class_Of_Box_1();
		WebElement child;
		/*String actual1;
		WebElement child;
		
		driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		WebElement main = driver.findElement(By.id("answer"));
		String expected1 = main.getAttribute("class");
		System.out.println(expected1);*/
		
		Boolean check = true;
		while (check) 
		{
	        driver.findElement(By.linkText("Repaint Box 2")).click();
			 child = driver.findElement(By.id("child"));
			driver.switchTo().frame(child);
			 actual1 = driver.findElement(By.id("answer")).getAttribute("class");
			System.out.println(actual1);
			if (actual1.equals(expected1))
			    {
				check = false;
				}
			driver.switchTo().parentFrame();

		}
       // proceedlink= driver.findElement(By.linkText("Proceed"));
		return actual1;
	}
	
	public WebElement get_Proceed_Link() {
		WebElement proceedlink = driver.findElement(By.linkText("Proceed"));
		return proceedlink;
	}
	

}
