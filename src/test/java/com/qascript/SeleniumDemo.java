package com.qascript;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemo {


    @Test
    public void OpenBrowser() throws InterruptedException  {
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "A:\\Softwares\\ChromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		System.out.println("Launch Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        System.out.println("Enter Usr name");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        System.out.println("Enter password");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Submitted");
        Thread.sleep(4000);        
        System.out.println("Title of the page is: " + driver.getTitle());
        Assert.assertTrue("Page title is not correct",driver.getTitle().equals("OrangeHRM"));
        driver.quit();
    }


}


