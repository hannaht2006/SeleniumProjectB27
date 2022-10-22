package com.cydeo.tests.homework.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoVerification {
    public static void main(String[] args) {
        //open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");
        String url = "https://practice.cydeo.com";
        String expectedWord = "cydeo";
        String expectedTitle = "Practice";
        String acctualTitle = driver.getTitle();
        if(url.contains(expectedWord)){
            System.out.println("URL contains: " + expectedWord);
        }else{
            System.out.println("URL doesn't contain:  " + expectedWord);
        }

        if (acctualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED ");
        }
        driver.quit();
    }
    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to
https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
 Expected: Practice
     */
}
