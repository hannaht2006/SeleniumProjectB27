package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        //1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();//can change to firefoxdriver() or other browsers driver

        //2- Create  instance of a chrome driver
        WebDriver driver = new ChromeDriver();//WebDriver is for all kind of browsers(firefox, safari, IE..) -> open an empty browser

        //3- Test if driver is working

        driver.get("https://www.google.com");//get method is helping us navigate to the webpage (getter method)
        //use https: to make sure work with all kind of browsers


    }
}
