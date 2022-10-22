package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Iframe_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //    1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

    }
@Test
public void iframeTask() {
    //switch to the iframe with using index number to work:
    // driver.switchTo().frame(0);

    //switch to the iframe with using id number
    //  driver.switchTo().frame("mce_0_ifr");

    //switch to the iframe with using iframe locator: safest way
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));


    WebElement textArea = driver.findElement(By.xpath("//p"));

    //4. Assert: “Your content goes here.” Text is displayed.

    Assert.assertTrue(textArea.isDisplayed());

    //need to switch back to main html using defaultContent()
    driver.switchTo().defaultContent();

    //if you have nested iframe and if you want to switch back to parent , you should use parentFrame()
    //driver.switchTo().parentFrame();

//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor” is display

    WebElement headerText = driver.findElement(By.xpath("//h3"));
    Assert.assertTrue(headerText.isDisplayed());

}
}
