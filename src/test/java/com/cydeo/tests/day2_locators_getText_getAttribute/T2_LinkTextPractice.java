package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

       Thread.sleep(3000);

        //3- Click to A/B Testing from top of the list.
        // WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));//find the element "A/B Testing" from webpage

        WebElement abTestLink = driver.findElement(By.partialLinkText("A/B"));
         abTestLink.click();

            //driver.findElement(By.linkText("A/B Testing")).click();//different way to click to "A/B Testing"

        Thread.sleep(3000);

        //4- Verify title is:
        //  Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("No A/B Test Title verification is PASSED");
        }else{
            System.out.println("No A/B Test Title verification is FAILED");
        }

        //5- Go back to home page by using the .back();
       driver.navigate().back();

        Thread.sleep(3000);

        //Verify title equals:
        //  Expected: Practice
        expectedTitle = "Practice";
        actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Practice Title verification is PASSED");
        }else{
            System.out.println("Practice Title verification is FAILED");
        }
        driver.quit();
    }
}
/*
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice
 */
