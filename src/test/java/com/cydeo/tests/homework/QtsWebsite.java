package com.cydeo.tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class QtsWebsite {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qtsdatacenters.com/");

        WebElement dataCenterModule = driver.findElement(By.xpath("(//a[@href='/data-centers'])[1]"));

        Actions act = new Actions(driver);
        act.moveToElement(dataCenterModule).pause(1000).perform();
        WebElement uniteState = driver.findElement(By.xpath("(//div[text()='United States'])[1]"));
        String uniteStateText = uniteState.getText();
        System.out.println(uniteStateText);

        Assert.assertEquals(uniteStateText, "UNITED STATES");

        List<WebElement> listOfDataCenter = driver.findElements(By.xpath("//div[@class='dropdown-subcategory-label']"));

        System.out.println("number of location: "+ listOfDataCenter.size());
        for(int i=0; i< listOfDataCenter.size(); i++){
            System.out.println(listOfDataCenter.get(i).getText());
        }

        driver.close();
    }
}
