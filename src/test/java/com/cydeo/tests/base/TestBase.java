package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
//This class is the parent of all Test class, and we made it as abstract, we don't need to create object

//you will update this class based on what you are keep writing in your most test classes instead writing in all test classes, you can just write in this class and you can extend your test class from this class
public abstract class TestBase {

    protected WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //in your work environment, you will be navigated  same link and you can still use TestBase class to navigate same page for all test class:
        //Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
