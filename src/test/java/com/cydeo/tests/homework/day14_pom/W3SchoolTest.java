package com.cydeo.tests.homework.day14_pom;

import com.cydeo.pages.W3SchoolPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W3SchoolTest {

    @Test
    public void double_click_me_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("w3school.url"));

//2. Switch to iframe.
        W3SchoolPage w3SchoolPage = new W3SchoolPage();

        Driver.getDriver().switchTo().frame(w3SchoolPage.iframe);

//3. Double click on the text “Double-click me to change my text color.”
        BrowserUtils.sleep(2);
       // System.out.println(w3SchoolPage.doubleClickMe.getText());

        Actions act = new Actions(Driver.getDriver());
        act.doubleClick(w3SchoolPage.doubleClickMe).perform();

//4. Assert: Text’s “style” attribute value contains “red”.

        Assert.assertTrue(w3SchoolPage.doubleClickMe.getAttribute("style").contains("red"));

        Driver.getDriver().switchTo().defaultContent();
    }

}
