package com.cydeo.tests.day11_upload_actions_javascriptexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Hover_Test {

    @Test
    public void hover_test(){

//  1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get(ConfigurationReader.getProperty("hover.url"));

        //locate all images:
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        WebElement profile1 = Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[1]"));
        WebElement profile2 = Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[2]"));
        WebElement profile3 = Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[3]"));

        Actions act = new Actions(Driver.getDriver());

        //  2. Hover over to first image
        act.moveToElement(image1).pause(1000).perform();

//        3. Assert:
//        a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

//        b. “view profile” is displayed
        Assert.assertTrue(profile1.isDisplayed());

//        4. Hover over to second image
        act.moveToElement(image2).pause(1000).perform();

//        5. Assert:
//        a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

//        b. “view profile” is displayed
        Assert.assertTrue(profile2.isDisplayed());

//        6. Hover over to third image
        act.moveToElement(image3).pause(1000).perform();

//        7. Confirm:
//        a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());

//        b. “view profile” is displayed
        Assert.assertTrue(profile3.isDisplayed());

        Driver.closeDriver();
    }
}
