package com.cydeo.tests.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day7 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }
    @Test
    public void checkingNumberTC1(){

        /*
        TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332
         */
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int actualNumberOfLinks = links.size();
        System.out.println("Actual Number Of Links = " + actualNumberOfLinks);
        int expectedNumberOfLinks = 355;
        Assert.assertEquals(actualNumberOfLinks,expectedNumberOfLinks);
    }

    @Test
    public void printTextOfLinks(){
        /*
        TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page
         */
        List<WebElement> links1 = driver.findElements(By.tagName("a"));
        for (WebElement eachLink : links1) {
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }
    }

    @Test
            public void linksNoText() {
    /*
   TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109
     */

        List<WebElement> links2 = driver.findElements(By.tagName("a"));
         int linkHaveNoText = 0;
        for (WebElement eachLink : links2) {
            if(eachLink.getText().equals("")){
                linkHaveNoText+=1;
            }
        }
        System.out.println("Number Link have no text: "+ linkHaveNoText);
        int actualLinkNoText = linkHaveNoText;
        int expectedLinkNoText = 259;
        Assert.assertEquals(actualLinkNoText,expectedLinkNoText);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
