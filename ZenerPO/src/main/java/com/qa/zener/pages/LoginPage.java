package com.qa.zener.pages;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.zener.testbase.TestBase;
import com.qa.zener.util.Util;
public class LoginPage extends TestBase 
{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn']")
	WebElement signin;
	
	@FindBy(xpath="/html/body/app-root/div/div/div/app-login/div/div/div/div/div/div/img")
	WebElement zenerLogo;
	
	@FindBy(id="mat-error-0")
	WebElement usernamevalerr;
	
	@FindBy(id="mat-error-1")
	WebElement passvalerr;
	
	@FindBy(xpath="//button[@class='swal2-actions']")
	WebElement okButton;
	
		
	public LoginPage() throws IOException
	{
	PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateZenerImage()
	{
      return zenerLogo.isDisplayed();
	}
		

	public boolean validateLoginPageValErrSt() throws IOException
	{
		username.click();
		username.sendKeys(Keys.TAB);
		return usernamevalerr.isDisplayed();

	}
	
	public boolean validateLoginPageErrSt() throws IOException
	{
		password.click();
		password.sendKeys(Keys.TAB);
		return passvalerr.isDisplayed();
	}
	
	
	public HomePage wrongCred(String un,String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();	
		okButton.click();
			
		return new HomePage();	
	}
	
	

	public boolean validateLoginPagePassErrSt() throws IOException
	{

		password.click();
		return password.isDisplayed();
	
	}
	
	
	public HomePage login(String un,String pwd) throws IOException, InterruptedException
	{
			
		username.sendKeys(un);
		password.sendKeys(pwd);
		if(signin.isEnabled())
		  {
			signin.click();
		  }
				
		return new HomePage();	
	}
}

