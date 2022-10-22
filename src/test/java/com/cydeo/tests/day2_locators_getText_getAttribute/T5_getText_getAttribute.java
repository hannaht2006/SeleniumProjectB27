package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {
    public static void main(String[] args) {
       //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //  Expected: Registration form
        WebElement headerTag = driver.findElement(By.tagName("h2"));//locate the web element
        String actualHeader = headerTag.getText();//find the header text
        String expectedHeader = "Registration form";
        if(actualHeader.equals(expectedHeader)){
            System.out.println("header text verification is PASSED");
        }else{
            System.out.println("header text verification is FAILED");
        }

        //4.Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));


        //5.Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String actualPlaceholder = firstNameInput.getAttribute("placeholder");
        String expectedPlaceholder = "first name";

        if(actualPlaceholder.equals(expectedPlaceholder)){
            System.out.println("Placeholder text verification is PASSED");
        }else{
            System.out.println("Placeholder text verification is FAILED");
        }
        driver.quit();

    }
}
/*
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
 */