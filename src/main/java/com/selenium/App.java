package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

	private static  WebDriver driver;
	@Test
	public void Apptest()throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		Register();



	    Thread.sleep(1000);

	    Assertion();
	    
	    driver.close();
		 

	}
	
	public static void Register() {
        
        driver.get("https://demo.automationtesting.in/Register.html");
        
        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
        
        firstname.sendKeys("Kotla Venu");
        lastname.sendKeys("Reddy");
        Email.sendKeys("kotlavenu27@gmail.com");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.xpath("//input[@value='Cricket']")).click();
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        WebElement lang = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a"));
        lang.click();

        WebElement dropdown1 = driver.findElement(By.xpath("//select[@placeholder='Year']"));
        Select drop1 = new Select(dropdown1);
        drop1.selectByVisibleText("2000");
        

        WebElement dropdown2 = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select drop2 = new Select(dropdown2);
        drop2.selectByVisibleText("July");
        

        WebElement dropdown3 = driver.findElement(By.xpath("//select[@placeholder='Day']"));
        Select drop3 = new Select(dropdown3);
        drop3.selectByVisibleText("27");
        
    }

    public static void Assertion() {
        
        WebElement text12 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/h1"));
        Assert.assertEquals(text12.getText(),"Automation Demo Site");
        System.out.println(text12.getText());
        String textget = text12.getText();
        String[] words= textget.split(" ");
        String password =words[1];
        System.out.println(password);
        driver.findElement(By.xpath("//textarea[@rows='3']")).sendKeys(password);
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File("C:\\Users\\Kotla\\Desktop\\Project\\screenshot.png"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }

    
    
    

}
