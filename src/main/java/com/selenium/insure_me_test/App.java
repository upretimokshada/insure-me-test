package com.selenium.insure_me_test;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\upret\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
       
        driver.get("http://3.83.52.137:8081/contact.html");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        driver.findElement(By.id("inputName")).sendKeys("Mokshada");
        driver.findElement(By.id("inputNumber")).sendKeys("1234567890");
        driver.findElement(By.id("inputMail")).sendKeys("mokshada@gmail.com");
        driver.findElement(By.id("inputMessage")).sendKeys("Final DevOps Project!!!");
        
        driver.findElement(By.id("my-button")).click();
        
        String message = driver.findElement(By.id("response")).getText();
        
        Assert.assertEquals("Message Sent", message);
        
        System.out.println("Taking Screenshot as proof");
        
        //take the screenshot of the testcase
        
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  File destFile = new File("screenshot.png");
		  
		  FileUtils.copyFile(screenShot, destFile);
		 
		  System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());
        
        Thread.sleep(3000);
    
    driver.quit();
    
    }
}
