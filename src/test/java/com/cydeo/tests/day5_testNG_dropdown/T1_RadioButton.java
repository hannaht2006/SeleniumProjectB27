package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_RadioButton {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        // 3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();
        System.out.println(hockeyButton.isSelected());

        //4. Verify “Hockey” radio button is selected after clicking.

        if (hockeyButton.isSelected()) {
            System.out.println("Hockey button is selected");
        } else {
            System.out.println("Hockey button is not selected");
        }
        System.out.println("-------------------------");

        //Test all radio button if they are working using collection and iterate loop:
        List<WebElement> sportRadioBtns = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement eachSport : sportRadioBtns) {//type iter and enter to get the loop
            eachSport.click();
            if (eachSport.isSelected()) {
                System.out.println(eachSport.getAttribute("id") + " Radio buttons are selected");
            } else {
                System.out.println(eachSport.getAttribute("id") + " Radio buttons are not selected");
            }
            // driver.quit();
        }
    }
}
