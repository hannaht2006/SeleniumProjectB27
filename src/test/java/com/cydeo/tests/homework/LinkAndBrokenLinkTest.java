package com.cydeo.tests.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkAndBrokenLinkTest {

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
    @Test
    public void brokenLinkTest(){
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        String homePage ="https://www.openxcell.com";

        List<WebElement> links3 = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links3.iterator();
        while(it.hasNext()){
        url = it.next().getAttribute("href")  ;
            System.out.println(url);
            if(url==null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            if(!url.startsWith(homePage)){
                System.out.println("URL belong to other domain, skip it");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode>=400){
                    System.out.println(url +" is invalid link");
                }
                else{
                    System.out.println(url + " is valid link");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
