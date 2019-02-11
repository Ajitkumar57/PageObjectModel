package com.qa.zener.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.zener.util.Util;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;

	
	
	public TestBase() throws IOException
	{
		try
		{
		prop=new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\ajit.swami\\eclipse-workspace\\ZenerPO\\src\\main\\java\\com\\qa\\zener\\config\\config.properties");
		prop.load(ip);
		
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initilization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajit.swami\\eclipse-workspace\\Studio\\input\\chromedriver1.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	


}
