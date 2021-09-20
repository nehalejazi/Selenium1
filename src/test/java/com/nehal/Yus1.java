package com.nehal;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yus1 {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}

	
	@Test(enabled=false)
	public void getTitle()
	{
		String title = driver.getTitle();
		assertEquals(title, "OrangeHRM", "No Match in title");
		
	}
	
	@Test(enabled=false)
	public void doLogin() throws Exception
	{
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("div#divUsername+#divPassword>input")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".button")).click();
		System.out.println(System.getProperty("user.dir"));
		Thread.sleep(3000);
		takePhoto(driver);
	}
	
	@Test
	public void testAdmin1() throws InterruptedException
	{
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("div#divUsername+#divPassword>input")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".button")).click();
		Actions action1 = new Actions(driver);
		WebElement e1 = driver.findElement(By.cssSelector("#menu_admin_viewAdminModule"));
		WebElement e2  = driver.findElement(By.cssSelector("#menu_admin_Job"));
		WebElement e3 = driver.findElement(By.cssSelector("#menu_admin_jobCategory"));
		action1.moveToElement(e1).build().perform();
		action1.moveToElement(e2).build().perform();
		e3.click();
		Thread.sleep(3000);
		
	}
	
	public static void takePhoto(WebDriver driver) throws IOException
	{
		TakesScreenshot tc  = (TakesScreenshot)driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		//File trg = new File("C:\\Users\\nehal\\eclipse-workspace\\Selenium1Maven\\Screenshots\\test1.png");
		File trg = new File(System.getProperty("user.dir")+"/Screenshots/test2.png");
		FileUtils.copyFile(src, trg);
		
	}

}
