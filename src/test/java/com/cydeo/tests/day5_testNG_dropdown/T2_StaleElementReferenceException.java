package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_StaleElementReferenceException {
    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/add_remove_elements/

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //        3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementBtn.click();

//        4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }

//        5. Click to “Delete” button.
        deleteButton.click();

        System.out.println("----------------------");

//        6. Verify “Delete” button is NOT displayed after clicking.

        // System.out.println("deleteButton.isDisplayed() "+ deleteButton.isDisplayed()); // if just use this line of code alone will get the staleElementReferenceException and the code will stop. therefore we need to use try .. catch to handle the exception:
        try {
            System.out.println("deleteButton.isDisplayed() "+ deleteButton.isDisplayed());

        } catch (StaleElementReferenceException e) {

            System.out.println("Stale Element Reference Exception is thrown and this is already expected");
        }
        driver.quit();
    }
}
