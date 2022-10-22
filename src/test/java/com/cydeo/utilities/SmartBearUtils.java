package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    /*
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
     */
    public static void loginToSmartBear(WebDriver driver,String userName, String password){
        WebElement userNameBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameBtn.sendKeys(userName);

        WebElement passwordBtn = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passwordBtn.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginBtn.click();

    }
}
