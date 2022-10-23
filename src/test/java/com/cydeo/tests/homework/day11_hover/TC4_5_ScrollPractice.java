package com.cydeo.tests.homework.day11_hover;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC4_5_ScrollPractice {
    @Test
    public void tc4_scrollpractice(){
    //        1- Open a chrome browser
       // Driver.getDriver().get(ConfigurationReader.getProperty("browser"));
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

//        3- Scroll down to “Powered by CYDEO”
        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        Actions act = new Actions(driver);
        BrowserUtils.sleep(1);
        act.moveToElement(poweredByCydeo).perform();

//        4- Scroll using Actions class “moveTo(element)” method

//        TC #5: Scroll practice 2
//        1- Continue from where the Task 4 is left in the same test.

//        2- Scroll back up to “Home” link using PageUP button
        WebElement homeBtn = driver.findElement(By.xpath("//a[text()='Home']"));
        act.moveToElement(homeBtn).perform();

    }
    @Test
    public void TC4_5(){
        Driver.getDriver().get(ConfigurationReader.getProperty("tc4.5.url"));
        WebElement powerByCydeoBtn = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));

        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(powerByCydeoBtn).pause(1000).perform();

        WebElement homeBtn = Driver.getDriver().findElement(By.xpath("//a[text()='Home']"));
        act.moveToElement(homeBtn).pause(1000).perform();
    }
}
