package com.cydeo.tests.homework.vytrack_project;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

//hover to activities module with truck driver log in:
        WebElement activityBtn = driver.findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]/a/span"));
        System.out.println(activityBtn.getText());


        WebElement calendarEventBtn = driver.findElement(By.xpath("//span[text()='Calendar Events']"));

        Actions act = new Actions(driver);
        act.moveToElement(activityBtn).pause(1000).perform();

//hover to "Calendar Events" and click
        act.moveToElement(calendarEventBtn).pause(1000).perform();

        calendarEventBtn.click();
        BrowserUtils.sleep(1);

        //verify "Calendar Events Activities
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Calendar Events - Activities");

        //click Create Calendar event" button
        WebElement calendarEventCreateBtn = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        calendarEventCreateBtn.click();

        //Write message "Scrum daily meeting"  at the description field
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));//id is changing so pay attention when located element

        WebElement textArea = driver.findElement(By.xpath("//p"));
        BrowserUtils.sleep(1);

        textArea.sendKeys("Scrum daily meeting");

        //Verify the message is written in the input box

        String actualTextInputBox = textArea.getText();

        Assert.assertEquals(actualTextInputBox, "Scrum daily meeting", "verification text in input box is failed");

        //switch back to main html page
        driver.switchTo().defaultContent();

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

    @DataProvider
    public Object[][] testData(){

        return new Object[][]{
                {"user31"},
                {"user32"},
                {"user33"}
        };
    }
}
