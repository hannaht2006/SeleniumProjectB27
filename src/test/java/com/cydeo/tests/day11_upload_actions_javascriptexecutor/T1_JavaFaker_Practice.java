package com.cydeo.tests.day11_upload_actions_javascriptexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_JavaFaker_Practice {

    @Test
    public void registration_form(){

//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

//        3. Enter first name
        WebElement firstnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstnameBox.sendKeys(faker.name().firstName());

//        4. Enter last name
        WebElement lastnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));

        lastnameBox.sendKeys(faker.name().lastName());

//        5. Enter username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

        //only using faker, will give us : rosea.murphy
        //we have to use logic to change the way it returning by .replace() method
        String userName = faker.name().username().replace(".", "");
        usernameBox.sendKeys(userName);//random username

//        6. Enter email address
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(faker.internet().emailAddress());

//        7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(faker.internet().password());

//        8. Enter phone number
        WebElement phoneNumberBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys(faker.numerify("571-###-####"));

//        9. Select a gender from radio buttons
        List<WebElement> genders = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));

        //click randomly number from 1 to 3 of the radio option

            genders.get(faker.number().numberBetween(0, 2)).click();// List index is from 0 -2


//        10. Enter date of birth
        WebElement dateOfBirthBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));

        dateOfBirthBox.sendKeys("11/11/2000");

//        11. Select Department/Office
        //select tag, so we have to use select class
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));

        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));

//        12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));

        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

//        13. Select programming language from checkboxes
        WebElement cCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='cplusplus']"));

        WebElement javaCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='java']"));

        WebElement javaScriptCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='javascript']"));

        javaCheckbox.click();

//        14. Click to sign up button
        WebElement signinBtn= Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));

        signinBtn.click();

//        15. Verify success message “You’ve successfully completed registration.” is displayed
        WebElement message = Driver.getDriver().findElement(By.xpath("//p"));

        String actualMessage = message.getText();
        System.out.println(actualMessage);

        Assert.assertEquals(actualMessage, "You've successfully completed registration!");

    }
}
