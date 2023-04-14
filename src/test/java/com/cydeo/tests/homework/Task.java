package com.cydeo.tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");

        WebElement closeButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        closeButton.click();


        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.visibilityOf(image));
//
        WebElement image = driver.findElement(By.xpath("//div[@class='_3eARKq']"));
        Actions ac = new Actions(driver);
        ac.moveToElement(image).pause(2).click().perform();
//        Thread.sleep(2);
//        image.click();
//        Thread.sleep(2);
//        image.click();
        WebElement electronicsBtn = driver.findElement(By.xpath("//div[@class='_1kidPb']/span[.='Electronics']"));
        electronicsBtn.click();

        ac.moveToElement(electronicsBtn).pause(1).perform();
        List<WebElement> elMenus = driver.findElements(By.xpath("//div[@class = '_1fwVde']/a[@title = 'Mobiles']/../a"));

        // or webElement:  //div[@class='_1QrT3s']/div[@class='_1fwVde'][1]/a
        System.out.println(elMenus.size());
        // int count = 1;
        for (int i = 1; i < elMenus.size(); i++) {
            System.out.println(i + ". " + elMenus.get(i).getText());

        }
    }
}
