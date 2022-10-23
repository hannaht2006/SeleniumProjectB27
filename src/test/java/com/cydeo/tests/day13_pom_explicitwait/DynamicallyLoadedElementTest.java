package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.DynamicallyLoadedElementPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicallyLoadedElementTest {

    @Test
    public void dynamically_loaded_page_element_1_test(){
//1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

//2. Click to start
        DynamicallyLoadedElementPage dynamicallyLoadedElementPage = new DynamicallyLoadedElementPage();
        dynamicallyLoadedElementPage.starBtn.click();

//3. Wait until loading bar disappears
      //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

       // wait.until(ExpectedConditions.invisibilityOf(dynamicallyLoadedElementPage.loadingBar));

        //replace with method just created from BrowserUtil class:
        BrowserUtils.waitForInvisibilityOf(dynamicallyLoadedElementPage.loadingBar);

//4. Assert username inputbox is displayed

        Assert.assertTrue(dynamicallyLoadedElementPage.inputUsernameBox.isDisplayed());

//5. Enter username: tomsmith
        dynamicallyLoadedElementPage.inputUsernameBox.sendKeys("tomsmith");

//6. Enter password: incorrectpassword
        dynamicallyLoadedElementPage.inputPasswordBox.sendKeys("password");

//7. Click to Submit button
        dynamicallyLoadedElementPage.submitBtn.click();

//8. Assert “Your password is invalid!” text is displayed.
      Assert.assertTrue(dynamicallyLoadedElementPage.errorMsg.isDisplayed());

    }
}
