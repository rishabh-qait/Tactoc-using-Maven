package com.qait.automation.MavenFirst;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class NewEmptyTestNGTest {
    
    WebDriver driver;
    
    LoginForm loginForm;
    
    @Test
    public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
        Assert.assertTrue(loginForm
                .loginWithIncorrectCredentials("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
    }
    
    @Test
    public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field(){
        loginForm.login("raman", "");
        // red border in password entry
        Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
    }
    
    @BeforeClass
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://s-hris.qainfotech.com");
        loginForm = new LoginForm(driver);
    }
    
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
    
}