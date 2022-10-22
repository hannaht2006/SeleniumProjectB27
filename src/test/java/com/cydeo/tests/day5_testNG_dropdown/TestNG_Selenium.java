package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    //go to google page to check the title
    WebDriver driver;//to make drive to be globe to use in any method

  @BeforeMethod
  public void setUpMethod(){
      //1.setup chrome browser
      driver = WebDriverFactory.getDriver("chrome");//don't need WebDriver in front of drive here
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }


    @Test
    public void googleTitle(){

        //2.navigate to google page
        driver.get("https://www.google.com");

        //3.verification title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not matching");//message for fail situation(it's optional)

    }

    @AfterMethod
    public void tearDownMethod(){
      driver.quit();
    }


}
