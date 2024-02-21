package com.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login{
	
	private WebDriver driver;
  
	@BeforeTest
  public void url() throws InterruptedException {
	  WebDriverManager.edgedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-logo-sprites']")));
		
  }
	
	@Test
	public void Loginpage() throws InterruptedException {
		WebElement login =this.driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));   
		login.click();
		Thread.sleep(3000);
		
		WebElement email =this.driver.findElement(POM.EMAIL);
		email.sendKeys("8143369534",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement pass =this.driver.findElement(POM.PASS);
		pass.sendKeys("Kotlavenu@27",Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void exit() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
