package com.cydeo.tests.homework.day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //    1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown

        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void dropDown(){

        Select dropdownState = new Select(driver.findElement(By.id("state")));

        //3. Select Illinois

        dropdownState.selectByValue("IL");

        //4. Select Virginia
        dropdownState.selectByVisibleText("Virginia");

        //5. Select California
        dropdownState.selectByIndex(5);

        //6. Verify
        //    final selected option is California.
//    Use all Select options. (visible text, value, index)
String expectedState = "California";
String actualState = dropdownState.getFirstSelectedOption().getText();

        Assert.assertEquals(actualState,expectedState);

    }
    /*
    TC #5: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
     */
@Test
public void dropdownTask5(){

    /*
    3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
     */

    Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
    Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
    Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

    selectYear.selectByVisibleText("1923");
    selectMonth.selectByValue("11");
    selectDay.selectByIndex(0);

    String actualYear = selectYear.getFirstSelectedOption().getText();
    String expectedYear = "1923";

    Assert.assertEquals(actualYear,expectedYear,"Year is matched with expected year");

    String actualMonth = selectMonth.getFirstSelectedOption().getText();
    String expectedMonth = "December";
    Assert.assertEquals(actualMonth,expectedMonth);

    String actualDay = selectDay.getFirstSelectedOption().getText();
    String expectedDay = "1";
    Assert.assertEquals(actualDay,expectedDay);

}

@Test
     public void dropdownTask6() {

/*
TC #6: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
*/
    //3. Click to non-select dropdown

    WebElement dropdownLink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
    dropdownLink.click();

//4. Select Facebook from dropdown
    WebElement facebookSelection = driver.findElement(By.xpath("//a[.='Facebook']"));
    facebookSelection.click();

//5. Verify title is “Facebook - Log In or Sign Up”
    String expectedTitleFacebook = "Facebook - Log In or Sign Up";
    String actualTitleFacebook = driver.getTitle();

    Assert.assertEquals(actualTitleFacebook,expectedTitleFacebook,"Title verification is failed");

}

@Test
    public void dropdownTask7() {
    /*
    TC #7: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */
    //3. Select all the options from multiple select dropdown.

    Select languageDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
    for (WebElement eachLanguage : languageDropdown.getOptions()) {

        eachLanguage.click();
        System.out.println(eachLanguage.getText());
    }
    languageDropdown.deselectAll();
}

    @Test
            public void printAllStates () {

        WebElement dropdownState = driver.findElement(By.xpath("//select[@id='state']"));
        Select dropdownStateBtn = new Select(dropdownState);
        for (WebElement eachState : dropdownStateBtn.getOptions()) {

            if(eachState.getText().equals("Select a State")){
                continue;
            }
            System.out.println(eachState.getText());
        }
    }



//@AfterMethod
//    public void tearDownMethod(){
//        driver.quit();
//}


}
