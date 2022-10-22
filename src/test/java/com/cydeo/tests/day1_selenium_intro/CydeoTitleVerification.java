package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoTitleVerification {
    public static void main(String[] args) {
        //1.opening chrome browser:
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //2. go to"https://www.cydeo.com"
        driver.get("https://www.cydeo.com");

        //3. verification title
        String expectedTitle = "Cydeo";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED ");
        }
        driver.quit();
    }
}
