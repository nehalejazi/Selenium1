package com.nehal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgGraph2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		String vericalXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String tooltipXpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		List<WebElement> list1 = driver.findElements(By.xpath(vericalXpath));
		System.out.println(list1.size());
		Actions a = new Actions(driver);
		for(WebElement e:list1)
		{
			a.moveToElement(e).perform();
			Thread.sleep(500);
			String aa =driver.findElement(By.xpath(tooltipXpath)).getText();
			System.out.println(aa);
		}
		

	}

}
