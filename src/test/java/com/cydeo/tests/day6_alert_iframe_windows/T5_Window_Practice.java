package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Window_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //    1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void windowTask(){

        //store main window
        String mainWindow = driver.getWindowHandle();

        // 4. Assert: Title is “Windows”

        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("before open new window = " + actualTitle);

// 5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();

        actualTitle = driver.getTitle();
        System.out.println("after open new window = " + actualTitle);


//6. Switch to new Window.
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

//7. Assert: Title is “New Window”

        String expectedTitleNewWindow = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleNewWindow);
// if want to go back to main window at the end: you can store mainWindow at very beginning of test, and you can switch() to window whenever you need
      //  driver.switchTo().window(mainWindow);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
