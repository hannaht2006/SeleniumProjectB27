package com.cydeo.tests.day4_xpath_findelements_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//        3. Locate all the WebElements on the page using XPATH and/or CSS
//        locator only (total of 6)
//        a. “Home” link
        // locate using cssSelector with class distribute syntax #2
        WebElement homeLink1 = driver.findElement(By.cssSelector("a.nav-link"));

        // locate using cssSelector with class distribute syntax #1
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        // locate using xpath with class distribute syntax #1
        WebElement homeLink3 = driver.findElement(By.xpath("//a[@class='nav-link']"));

        // locate using xpath with href distribute syntax #1
        WebElement homeLink4 = driver.findElement(By.xpath("//a[@href='/']"));

//        b. “Forgot password” header
        // locate using cssSelector with class distribute syntax #1
        WebElement forgotPassword1 = driver.findElement(By.cssSelector("div[class='example']>h2"));

        // locate using cssSelector with class distribute syntax #2
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div.example>h2"));

        // locate using xpath with text distribute syntax #1
        WebElement forgotPassword3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // or locate using xpath with text distribute syntax #1
        WebElement forgotPassword4 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        // locate using xpath with class attribute from parent to child syntax #1
        WebElement forgotPassword5 = driver.findElement(By.xpath("//div[@class='example']/h2"));


//        c. “E-mail” text
        // locate using xpath with text attribute syntax #1
        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));

        // locate using xpath with contains attribute syntax #1
        WebElement emailText2 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));

//        d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

//        e. “Retrieve password” button
        WebElement retrivePassword = driver.findElement(By.cssSelector("button[id='form_submit']>i"));


//        f. “Powered by Cydeo text
        WebElement powerByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

//        4. Verify all web elements are displayed.

        // isDisplayed() method return to boolean true/false: to check if web element is displayed, will return "true"
        System.out.println("homeLink1.isDisplayed() "+ homeLink1.isDisplayed());

        System.out.println("forgotPassword1.isDisplayed() = " + forgotPassword1.isDisplayed());

        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());

        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());

        System.out.println("retrivePassword.isDisplayed() = " + retrivePassword.isDisplayed());

        System.out.println("powerByCydeo.isDisplayed() = " + powerByCydeo.isDisplayed());

    }
}
