package com.cydeo.tests.homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager. chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        String expectedheader = "Log in to ZeroBank";
        WebElement headerTag = driver.findElement(By.tagName("h3"));
        String actualHeader = headerTag.getText();
        if(actualHeader.equals(expectedheader)){
            System.out.println("header verification is PASSED");
        }else{
            System.out.println("header verification is FAILED");
        }
        driver.quit();

    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */
