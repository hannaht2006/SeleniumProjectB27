package com.cydeo.tests.homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1_OfficeHour {
    @Test
    public void test1() {
        //1. setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. go to"https://www.selenium.dev"
        driver.get("https://www.selenium.dev");

        //3. verify the url is "https://www.selenium.dev/"
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/","verify current url");
        driver.close();
    }


}
