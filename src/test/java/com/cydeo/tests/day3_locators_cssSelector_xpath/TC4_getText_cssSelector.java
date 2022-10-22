package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4_getText_cssSelector {
    public static void main(String[] args) {
     //   1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

     //   2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

      //  3- Verify “Reset password” button text is as expected:
      //  Expected: Reset password

        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button.login-btn"));
        String expectedResetPasswordButton = "Reset password";
        String actualResetPasswordButton = resetPasswordButton.getText();

        if(actualResetPasswordButton.equals(expectedResetPasswordButton)){
            System.out.println("Reset password button verification passed");
        }else{
            System.out.println("Reset password button verification failed");
        }
driver.quit();
    }
}
