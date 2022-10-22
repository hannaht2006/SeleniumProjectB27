package com.cydeo.tests.homework.day6_arlert;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC5 {
    WebDriver driver;

    @BeforeMethod

  public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");


    }

    @Test
    public void verifyTitle(){
        //4. Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(),"Windows");

        //5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();

        String afterOpenNewWindowTitle = driver.getTitle();
        System.out.println("After open new window title: " + afterOpenNewWindowTitle);

        //6. Switch to new Window.
        //7. Assert: Title is “New Window”
        Set<String> handle = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(handle);

        for(String each : windows){
            driver.switchTo().window(each);
            System.out.println("each window: " + each);
        }


        Assert.assertEquals(driver.getTitle(), "New Window");

    }
    /*
    TC #5: Window Handle practice

1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
     */
}
