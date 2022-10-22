package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_getText_getAttribute {
    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

       // 3- Verify “remember me” label text is as expected:
      //  Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label text verification is PASSED");
        }else{
            System.out.println("Remember me label text verification is FAILED");
        }
      //  4- Verify “forgot password” link text is as expected:
      //  Expected: FORGOT YOUR PASSWORD?
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPassword = "FORGOT YOUR PASSWORD?";
        String actualForgotPassword = forgotPassword.getText();

        if(actualForgotPassword.equals(expectedForgotPassword)){
            System.out.println("Forgot password link text verification passed!");
        }else{
            System.out.println("actualForgotPassword = " + actualForgotPassword);
            System.out.println("expectedForgotPassword = " + expectedForgotPassword);
            System.out.println("Forgot password link text verification failed!");
        }

        //5- Verify “forgot password” href attribute’s value //contains expected:
       // Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPassword.getAttribute("href");//get the href link text

        if(actualInHref.contains(expectedInHref)){
            System.out.println("Href attribute value verification passed!" );
        }else{
            System.out.println("Href attribute value verification failed!");
        }
driver.quit();
    }
}
