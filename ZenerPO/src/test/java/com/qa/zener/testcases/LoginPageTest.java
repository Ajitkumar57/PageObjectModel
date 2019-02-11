package com.qa.zener.testcases;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zener.pages.HomePage;
import com.qa.zener.pages.LoginPage;
import com.qa.zener.testbase.TestBase;

public class LoginPageTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		initilization();
	    loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() 
	{
      String title=loginpage.validateLoginPageTitle();
      Assert.assertEquals(title, "Zener");
	}
	@Test(priority=2)
	public void ZenerImageLogoTest()
	{
		boolean flag=loginpage.validateZenerImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ZenerLoginValdationTest() throws IOException
	{
		String expectedMessage = "Username is required";
		boolean message = loginpage.validateLoginPageValErrSt();
		Assert.assertEquals(expectedMessage, "Username is required");
		 
	}
	
	
	@Test(priority=4)
	public void ZenerLoginValdationTestPass() throws IOException
	{
		String expectedMessage = "Password is required";
		boolean message = loginpage.validateLoginPageErrSt();
		Assert.assertEquals(expectedMessage, "Password is required");
	}
	
	@Test(priority=5)
	public void inValid() throws IOException, InterruptedException
	{
		homepage =loginpage.login(prop.getProperty("username1"),prop.getProperty("password1"));
		
	}
	
	
	
	@Test(priority=6)
	public void loginTest() throws IOException, InterruptedException
	{
		
		
		homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
}
