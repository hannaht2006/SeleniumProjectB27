package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarInsuranceAppVerification {

    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to
        //https://www.qa1.excelsoirinsurance.com/login
        driver.get("https://www.qa1.excelsoirinsurance.com/login");

        //3. Verify URL contains
        //     Expected: "excelsoirinsurance"
        String actualURL = driver.getCurrentUrl();//come from browser
        String expectedText = "excelsoirinsurance";//come from requirement
        if (actualURL.contains(expectedText)){
            System.out.println("URL verification is PASSED");
        }else{
            System.out.println("URL verification is FAILED");
        }

        //4. Verify title:
        //       Expected: "Login | Excelsoir Insurance"
        String expectedTitle = "Login | Excelsoir Insurance";
        String actualTitle = driver.getTitle();
        if(actualURL.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED");
        }
        driver.quit();
    }
}
/*
1. Open Chrome browser
2. Go to
https://www.qa1.excelsoirinsurance.com/login
3. Verify URL contains
     Expected: "excelsoirinsurance"
4. Verify title:
       Expected: "Login | Excelsoir Insurance"
 */