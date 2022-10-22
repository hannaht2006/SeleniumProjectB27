package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryAppLogin {
    public static void main(String[] args) {

        //1. open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2.https://library2.cydeo.com/login.html
        driver.get("https://library2.cydeo.com/login.html");

        //3.Enter username: "incorrect@email.com"
        WebElement usernameInput = driver.findElement(By.id("inputEmail"));//look for locator web element : id
        usernameInput.sendKeys("incorrect@email.com");

        //**using classname for practicing: only safe for username
       // WebElement usernameInput = driver.findElement(By.className("form-control"));

        //4.Enter password : incorrect password
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("incorrect password");

        //5. click to Sign in button
        WebElement signinBtn = driver.findElement(By.tagName("button"));//for this practice we can use tagName
        signinBtn.click();


        //5.Verify: visually "sorry, Wrong Email or Password" displayed



    }
}
