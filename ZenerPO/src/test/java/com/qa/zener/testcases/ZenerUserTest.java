package com.qa.zener.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zener.pages.HomePage;
import com.qa.zener.pages.LoginPage;
import com.qa.zener.pages.ZenerUserPage;
import com.qa.zener.testbase.TestBase;

public class ZenerUserTest extends TestBase 
{

	LoginPage loginpage;
	HomePage homepage;
	ZenerUserPage zeneruser;
	public ZenerUserTest() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initilization();
	    loginpage=new LoginPage();
	    homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	
	   @Test(priority=1)
	   public void verifyZenerUserTest() throws IOException
	   {
		   zeneruser=homepage.clickOnMaster(); 
		   
	   }
	   
	   

	
	   


	
	

	@AfterMethod
    public void tearDown()
    {
    //driver.quit();
    }

}
