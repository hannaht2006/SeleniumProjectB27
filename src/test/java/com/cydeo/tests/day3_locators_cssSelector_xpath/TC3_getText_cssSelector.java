package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC3_getText_cssSelector {
    public static void main(String[] args) {
       // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

       // 3- Verify “Log in” button text is as expected:
       // Expected: Log In

        //located using cssSelector by type attribute
       // WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));

        //located using cssSelector by  value attribute
       // WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Log In']"));

        //located using cssSelector by class attribute
        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='login-btn']"));

        //located using cssSelector by onclick attribute with syntax #2
       // WebElement loginBtn = driver.findElement(By.cssSelector("input.login-btn"));
       // WebElement loginBtn = driver.findElement(By.cssSelector("input[onclick=\"BX.addClass(this, 'wait');\"]));

        String actualLoginBtn = loginBtn.getAttribute("value");
        String expectedLogInText = "Log In";

        if(actualLoginBtn.equals(expectedLogInText)){
            System.out.println("Log in button verification passed");
        }else{
            System.out.println("Log in button verification failed");
        }
        driver.quit();
    }
}
