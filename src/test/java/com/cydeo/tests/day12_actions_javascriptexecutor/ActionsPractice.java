package com.cydeo.tests.day12_actions_javascriptexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractice {
    @Test
    public void task_4_and_5_test(){
        //1. open chrome browser
        //2. Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- create Acctions object
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        Actions action = new Actions(Driver.getDriver());

        //4- Scroll down to “Powered by CYDEO” using Actions class “moveTo(element)” method
       action.moveToElement(cydeoLink).pause(1000).perform();

//        2- Scroll back up to “Home” link using PageUP button (we don't use this Keys.PAGE_UP in testing since it is not powerful like moveToElement())
        BrowserUtils.sleep(1);
        action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

        Driver.closeDriver();
    }
}
