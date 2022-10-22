package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //    1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alertTask1(){

        // 3. Click to “Click for JS Alert” button

        WebElement informationAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertBtn.click();

        // 4. Click to OK button from the alert
// to handle JS alerts we have to use Alert for switching driver to alert form
        Alert alert = driver.switchTo().alert();// Alert is interface
// accept() method will click OK button

        //if you want to get text of alert window you can use getText() method
        System.out.println("alert.getText() = " + alert.getText());

        alert.accept();

// 5. Verify “You successfully clicked an alert” text is displayed

        WebElement textMessage = driver.findElement(By.xpath("//p[@id='result']"));

        String actualTextMessage = textMessage.getText();
        String expectedTextMessage = "You successfully clicked an alert";

        //verification: display and matched text message
        Assert.assertEquals(actualTextMessage,expectedTextMessage,"Text message is not matched with requirement");

        //check if text is displayed only
        Assert.assertTrue(textMessage.isDisplayed());

    }
}
