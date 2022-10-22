package com.cydeo.tests.homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EstyTitleVerification {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        //4. Verify title:
        //Expected: “Wooden spoon | Etsy”
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED");
        }
        driver.quit();


    }
}
/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */
