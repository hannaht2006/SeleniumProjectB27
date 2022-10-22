package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_Locator_GetText {
    public static void main(String[] args) {

//1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");//create web browser by calling getDriver method from utilities package
        driver.manage().window().maximize();

//2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


//3- Enter incorrect username: “incorrect”

      // driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect"); // 1 line code like this will just use 1 time, we should break the code down like below:

       WebElement inputUsername = driver.findElement(By.name("USER_LOGIN"));
       inputUsername.sendKeys("incorrect");



//4- Enter incorrect password: “incorrect”
      WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
      inputPassword.sendKeys("incorrect");

//5- Click to login button.
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

//6- Verify error message text is as expected:
//Expected: Incorrect login or password

        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectederrorMessage = "Incorrect login or password";
        String actualerrorMessage = errorMessage.getText();

        if(actualerrorMessage.equals(expectederrorMessage)){
            System.out.println("Error Message verification PASSED");
        } else{
            System.out.println("Error Message verification FAILED");
        }
        driver.quit();

    }
}
