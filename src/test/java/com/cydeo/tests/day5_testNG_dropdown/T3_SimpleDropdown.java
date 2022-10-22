package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SimpleDropdown {
    WebDriver driver;

    @BeforeMethod
   public void setUpMethod(){
        //    1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");//don't need WebDriver in front of drive here
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void simpleDropdown(){
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        // 3. Verify “Simple dropdown” default selected value is correct
        //    Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));//create simpleDropdown object from select class, argument is WebElement

      //  simpleDropdown.getFirstSelectedOption();//to get the default option to use the method getFirstSelectedOption()

        String actualSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();//getText() to get text from the object simpleDropdown.getFirstSelectedOption()

        String expectedsimpleDropdown = "Please select an option";

        Assert.assertEquals(actualSimpleDropdown,expectedsimpleDropdown);

        //  4. Verify “State selection” default selected value is correct
//    Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expectedStateDropdown = "Select a State";

        String actualStateDropdown = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateDropdown,expectedStateDropdown);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
