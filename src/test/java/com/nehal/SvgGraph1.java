package com.nehal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgGraph1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1ONGR_en-GBGB948GB948&oq=covid+cases+in+india&aqs=chrome..69i57j0i433i512j0i457i512j0i512l4j69i61.6384j0j7&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.xpath("//div[text()='I agree']")).click();
		
		List<WebElement> list1 = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		Actions act = new Actions(driver);
		for(WebElement e:list1)
		{
			act.moveToElement(e).perform();
			String text = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(text);
		}

	}

}
