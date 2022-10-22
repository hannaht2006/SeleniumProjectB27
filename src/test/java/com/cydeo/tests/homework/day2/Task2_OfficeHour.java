package com.cydeo.tests.homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2_OfficeHour {
    @Test
    public void test2() {

        //1. setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. go to "https://www.google.com"
        driver.get("https://www.google.com");

        //3. verify title contains "Google"
        Assert.assertTrue(driver.getTitle().contains("Google"));

        //4. navigate to "https://www.etsy.com"
        driver.navigate().to("https://www.etsy.com");

        //5. verify not in google page
        Assert.assertFalse(driver.getTitle().contains("Google"));

        //6. Verify the title contains "Etsy"
        Assert.assertTrue(driver.getTitle().contains("Etsy"));
        driver.close();
    }
}
