package com.qa.zener.pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.zener.testbase.TestBase;

public class ZenerUserPage extends TestBase  
{


	@FindBy(xpath="//*[@id=\"sidebar\"]/div[1]/div/ul/li/div/ul/li[1]/a")
	WebElement masterZener;
	
	public ZenerUserPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ZenerUserPage homeZenerUser() throws IOException 
	{
		masterZener.click();
		return new ZenerUserPage();
	
	}
	
	

}
