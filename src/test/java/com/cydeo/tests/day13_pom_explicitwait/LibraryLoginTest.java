package com.cydeo.tests.day13_pom_explicitwait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLoginTest {
    LibraryLoginPage libraryLoginPage;// = new LibraryLoginPage();// put here to make the object global, can be access by all tests

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url"));
        libraryLoginPage = new LibraryLoginPage();//add this line here (@BeforeMethod) to create new Driver session for the next test case

    }

    @Test
    public void required_field_error_message_test() {
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com/
      //  Driver.getDriver().get("https://library1.cydeo.com/");

//3- Do not enter any information
//4- Click to “Sign in” button
     //   LibraryLoginPage libraryLoginPage = new LibraryLoginPage();//create object to use method of LibraryLoginPage class

        libraryLoginPage.signInBtn.click();

//5- Verify expected error is displayed:
//Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMsg.isDisplayed());
    }

        @Test
       public void invalid_email_format_error_message_Test(){

//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com/
   Driver.getDriver().get("https://library1.cydeo.com/ ");

//3- Enter invalid email format
      //  LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
   libraryLoginPage.inputUsername.sendKeys("something"+ Keys.ENTER);

//4- Verify expected error is displayed:
//Expected: Please enter a valid email address.
    Assert.assertTrue(libraryLoginPage.enterInvalidEmailErrorMsg.isDisplayed());

        }

 @Test
 public void library_negative_login_test(){
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com/
//3- Enter incorrect username or incorrect password
     libraryLoginPage.inputUsername.sendKeys("wrong@email.com");
     libraryLoginPage.inputPassword.sendKeys("incorrect");
     libraryLoginPage.signInBtn.click();

//4- Verify title expected error is displayed:
//Expected: Sorry, Wrong Email or Password
     Assert.assertTrue(libraryLoginPage.wrongEmailAndPasswordErrorMsg.isDisplayed());

 }

 @Test
 public void library_positive_login_test(){
     //1- Open a chrome browser
//2- Go to: https://library1.cydeo.com/
//3- Enter incorrect username or incorrect password
     libraryLoginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("library.app.username"));
     libraryLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("library.app.password"));
     libraryLoginPage.signInBtn.click();
 }

 @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
 }

}
