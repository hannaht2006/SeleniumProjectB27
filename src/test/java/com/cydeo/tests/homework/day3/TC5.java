package com.cydeo.tests.homework.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC5 {
    public static void main(String[] args) {

       // TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
       // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

       // 3- Enter incorrect username into login box:
        WebElement login = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        login.sendKeys("incorrect");


       // 4- Click to `Reset password` button
        WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetPasswordBtn.click();

       // 5- Verify “error” label is as expected
       // Expected: Login or E-mail not found

        WebElement errorLabel = driver.findElement(By.cssSelector("div.errortext"));
        String expectedErrorLabel = "Login or E-mail not found";
        String actualErrorLabel = errorLabel.getText();
        System.out.println(actualErrorLabel);
        if (actualErrorLabel.equals(expectedErrorLabel)){

            System.out.println("Error label verification passed");
        }else{
            System.out.println("Error label verification failed");
        }
        driver.quit();
    }
}
