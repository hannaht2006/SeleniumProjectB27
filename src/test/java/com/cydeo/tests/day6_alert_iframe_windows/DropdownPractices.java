package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //    1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @Test
    public void dropdownTask4(){
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // 3. Select Illinois using visible text
        selectState.selectByVisibleText("Illinois");// selectBy() as click()

//4. Select Virginia using value
        selectState.selectByValue("VA");

//5. Select California using index
        selectState.selectByIndex(5); //index starting from 0

        //6. Verify final selected option is California.

        String actualFinalOption = selectState.getFirstSelectedOption().getText();//using getFirstSelectedOption() to
        // get current selection option in the dropdown list

        String expectedFinalOption ="California";

        Assert.assertEquals(actualFinalOption,expectedFinalOption,"Final selected option verification is fail");//instead using if ... else... we use Assert... to compare actual and expected option

//    finding index number from option:
        int index = -1;// set -1 so when eachState start the loop, 1st state will be 0
        for (WebElement eachState : selectState.getOptions()) {
            index++;
            if(eachState.getText().equals("California")){//eachState is webelement , therefore we use getText() to convert it to String to compare with "California" String
                System.out.println(index);
            }
        }

    }
@Test
    public void dropdownTask7() throws InterruptedException {
        Select selectLanguage = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

//    3. Select all the options from multiple select dropdown.
    //    4. Print out all selected values.
    for (WebElement eachLanguage : selectLanguage.getOptions()) {//using for select all option

        eachLanguage.click();
        System.out.println("eachLanguage.getText() = " + eachLanguage.getText());

        Thread.sleep(1000);
    }

//    5. Deselect all values.
    selectLanguage.deselectAll();

}

@AfterMethod
    public void tearDown(){
        driver.quit();
}



}
