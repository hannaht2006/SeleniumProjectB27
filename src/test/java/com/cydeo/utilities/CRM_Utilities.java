package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void login_crm(WebDriver driver){

        WebElement userNameBtn = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameBtn.sendKeys("hr2@cydeo.com");

        WebElement passwordBtn = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBtn.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

    }

    public static void login_crm(WebDriver driver, String username, String password){
        WebElement userNameBtn = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameBtn.sendKeys(username);

        WebElement passwordBtn = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBtn.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

    }
}
/*
1. Create a new method for login
2. Create a method to make Task3 logic re-usable
3. When method is called, it should simply login

This method should have at least 2 overloaded versions.

Method #1 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver


Method #2 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
• Arg2: String username
• Arg3: String password

 */