package com.cydeo.tests.day12_actions_javascriptexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_and_Drop {
    @Test
    public void dragAndDropTest(){

//1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

//2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
//click accept cookie button to not have any issue in our test

//        WebElement acceptCookiesBtn = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
//        acceptCookiesBtn.click();

   // create Actions object:
        Actions act = new Actions(Driver.getDriver());

 //drag and drop smallcircle to big circle:
//fast version:
        //act.dragAndDrop(smallCircle,bigCircle).perform();

 //slower version:chaining
        act.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();


//3. Assert:
//-Text in big circle changed to: “You did great!”

        String actualTextOnBigCircle = bigCircle.getText();
        String expectedText = "You did great!";

        Assert.assertEquals(actualTextOnBigCircle,expectedText);
    }
}
