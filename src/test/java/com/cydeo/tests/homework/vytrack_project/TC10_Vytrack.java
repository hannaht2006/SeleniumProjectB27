package com.cydeo.tests.homework.vytrack_project;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC10_Vytrack {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login ");
    }

    @Test
    public void loginHomepageTruckDriver() throws InterruptedException {

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys("user31");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();

        Thread.sleep(3000);

        String actualHomepageTitle = driver.getTitle();
        System.out.println("Title: "+ actualHomepageTitle);

        String expectedHomepageTitle = "Dashboard";
        Assert.assertEquals( actualHomepageTitle,expectedHomepageTitle);

//activities module with truck driver log in:
        WebElement activityBtn = driver.findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]/a/span"));
        activityBtn.click();
        System.out.println(activityBtn.getText());
    }

    @Test
    public void loginHomepageStoreManager() throws InterruptedException {
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys("storemanager72");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();

        Thread.sleep(3000);

        String expectedHomepageTitle = "Dashboard";
        String actualHomepageTitle = driver.getTitle();

        Assert.assertEquals(actualHomepageTitle,expectedHomepageTitle);

    }

    @Test
    public void loginHomepageSaleManager() throws InterruptedException {
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys("salesmanager72");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();

        Thread.sleep(3000);

        String expectedHomepageTitle = "Dashboard";
        String actualHomepageTitle = driver.getTitle();

        Assert.assertEquals(actualHomepageTitle,expectedHomepageTitle);



    }

    @Test
    public void activityBtn(){

        WebElement activityBtn = driver.findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]/a/span"));
        activityBtn.click();
        System.out.println(activityBtn.getText());
    }

    @DataProvider
    public Object[][] testData(){

        return new Object[][]{
                {"user31"},
                {"user32"},
                {"user33"}
        };
    }
}
