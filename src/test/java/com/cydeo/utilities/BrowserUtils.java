package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {
    //methods are static type because we do not want to create an object to call this method. we just call those method with class name

    /**
     * This method is used to pause the code for given seconds
     * It is static method, we can call the method with class name as below:
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
            System.out.println("exception happened in sleep method");
        }
    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    //BrowserUtils.verifyTitle(driver,"Google")

    public static void verifyTitle(WebDriver driver,String expectedTitle) {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
