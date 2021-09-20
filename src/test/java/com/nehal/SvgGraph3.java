package com.nehal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgGraph3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.switchTo().frame("svg_result");
		while(true) {
		List<WebElement> list1 = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"));
		for(WebElement e:list1)
		{
			String text = null;
			text = e.getAttribute("d");
			System.out.println(text);
		}
		}

	}

}
