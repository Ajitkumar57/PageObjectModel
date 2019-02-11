package com.qa.zener.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zener.testbase.TestBase;

public class HomePage  extends TestBase 

{
	
	@FindBy(xpath="//button[@class='btn btn-primary dropdown-toggle']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\'sidebar\']/div[1]/div/ul/li/a/span")
	WebElement masterMenu;
	
	@FindBy(xpath="/html/body/app-root/div/div/div/app-service-platform/div/main/div/div[1]/div[1]/a/div")
	WebElement ihmDashboard;
	

	
	
	
	
	public HomePage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateIHMImage()
	{
      return ihmDashboard.isDisplayed();
	}
	
	
	public ZenerUserPage clickOnMaster() throws IOException
	{
		masterMenu.click();
		return new ZenerUserPage();
	}
	

	public boolean validateHomeUserNamPagelableTitle()
	{
		return userNameLabel.isDisplayed();
	}




		
}
