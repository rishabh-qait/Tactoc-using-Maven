package com.qait.automation.MavenFirst;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestByClasses {
	Tactoc_Homepage homepageObject;
	Tactoc_Grid gridobject;
	Tactoc_Colormatch colormatchobject;
	DragAndDrop dragobject;
	LaunchPopup popupobject;
	GenerateToken generatetokenobject;
	WebDriver driver;
	
	
	
	@Test (priority=1)
	public void test1_attempt_Click_On_BasicCourse() 
	{
		
		
		homepageObject.get_Basic_Course_link();
		Assert.assertEquals(homepageObject.link_Basic_Course.getText(), "Basic Course");
		homepageObject.link_Basic_Course.click();
	
	
	}
	@Test (priority=2) 
	public void test2_attempt_Click_To_ChooseGreen() {
		
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		 gridobject.get_Greenbox();
		 Class<? extends WebElement> classname = gridobject.get_Greenbox().getClass();
		 System.out.println("This is the class"+classname);
		 
		 Assert.assertEquals(gridobject.get_Greenbox().getAttribute("class"),"greenbox");
		 gridobject.greenboxelement.click();
		
	
	}
	@Test (priority=3)
	public void test3_attempt_Unsuccessful__Color_Match_And_Proceed()
	{
		
		
		 String classofbox1=colormatchobject.get_Class_Of_Box_1();
		
         String classofbox2=colormatchobject.get_Diff_Class_Of_Box_2();
		 Assert.assertNotEquals(classofbox1, classofbox2);
		 
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		 Assert.assertEquals("http://10.0.1.86/tatoc/error", driver.getCurrentUrl());
		 driver.navigate().back();
		
		 
		
		 
		
	
	}
	@Test (priority=4) 
	public void test4_attempt_Successful__Color_Match_And_Proceed()
	{
		
		
		 String classofbox1=colormatchobject.get_Class_Of_Box_1();
		
         String classofbox2=colormatchobject.get_Class_Of_Box_2_Sameasbox1();
		 Assert.assertEquals(classofbox1,classofbox2 ); 
		 
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		 Assert.assertEquals("http://10.0.1.86/tatoc/basic/drag", driver.getCurrentUrl());
		 
		 
		
		 
		
	
	}
	
	
	
//	@Test (priority=5) //(dependsOnMethods= {"attempt_successful__color_match_and_proceed"})
	public void test5_attempt_Unsuccessful_Drag_Will_Goto_Errorpage()
	{
		//drag=new DragAndDrop(driver);
		WebElement from,to;
		from=dragobject.getdragelement();
		to=dragobject.getdropelement();
		dragobject.dragAndDrop(from,from);
		 Assert.assertEquals("http://10.0.1.86/tatoc/error", driver.getCurrentUrl());
		driver.navigate().back();
	}
	@Test (priority=6) 
	
	public void test6_attempt_Successful_Drag_Will_Goto_Nextpage()
	{
		
		WebElement from,to;
		from=dragobject.getdragelement();
		to=dragobject.getdropelement();
		dragobject.dragAndDrop(from,to);
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		 Assert.assertEquals("http://10.0.1.86/tatoc/basic/windows", driver.getCurrentUrl());
		
	}
	
	
	@Test (priority=7) 
	public void test7_attempt_Proceed_No_Text() 
	{
		
		popupobject.submitText("");
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		Assert.assertEquals("http://10.0.1.86/tatoc/error",driver.getCurrentUrl());
		driver.navigate().back();
		
		
		
	}
	@Test (priority=8)
	public void test7_attempt_Proceed_Some_Text() 
	{
		
		popupobject.submitText("Rishabh jain");
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/cookie",driver.getCurrentUrl());
		
		
		
		
	}
	@Test  (priority=9)
	public void test8_attempt_Click_After_Notadding_Cookie()throws InterruptedException 
	{
		
		generatetokenobject.generateTokenAndNotAddCookie();
		
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		 Assert.assertEquals("http://10.0.1.86/tatoc/error", driver.getCurrentUrl());
		 driver.navigate().back();
		
	}
	@Test  (priority=10)
	public void test8_attempt_Click_After_Adding_Cookie()throws InterruptedException 
	{
		
		generatetokenobject.generateTokenAndAddCookie();
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/cookie#", driver.getCurrentUrl());
		 WebElement proceed=colormatchobject.get_Proceed_Link();
		 proceed.click();
		
		
	}
	 @BeforeClass 
	    public void launchBrowser(){
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\rishabh.jain\\eclipse-workspace\\chromedriver.exe" );
	        driver = new ChromeDriver();
	        driver.get("http://10.0.1.86/tatoc");
	        homepageObject = new Tactoc_Homepage(driver);
	      gridobject = new Tactoc_Grid(driver);
	       colormatchobject = new Tactoc_Colormatch(driver);
	       dragobject = new DragAndDrop(driver);
	       popupobject  = new LaunchPopup(driver);
	       generatetokenobject  = new GenerateToken(driver);
	    }
	    
	   @AfterClass
	    public void closeBrowser() throws InterruptedException{
		   Thread.sleep(2000);
		   
		   driver.quit();
	        
	    }
	
	
	

}
