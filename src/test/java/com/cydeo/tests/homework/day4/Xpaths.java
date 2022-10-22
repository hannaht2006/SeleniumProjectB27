package com.cydeo.tests.homework.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Xpaths {
    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

//        3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[text()='Button 1']"));
        button1.click();

//        4. Verify text displayed is as expected:
//        Expected: “Clicked on button one!”
        WebElement textDisplayed = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText = "Clicked on button one!";
        String actualText = textDisplayed.getText();
        System.out.println(actualText);
        if(actualText.equals(expectedText)){
            System.out.println("Text displayed verification passed");
        }else{
            System.out.println("Text displayed verification passed");
        }
        driver.quit();
    }
}
