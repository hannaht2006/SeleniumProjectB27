package com.cydeo.tests.homework.day10;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC1_RegistrationForm {

    @Test
    public void registrationFormTest(){

        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get("https://practice.cydeo.com/registration_form");

        //3. Enter first name
        WebElement firstnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();
        firstnameBox.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));

        lastnameBox.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys(faker.bothify("###???????"));

        //6. Enter email address
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(faker.bothify("???##@??????.com"));

        //7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(faker.bothify("@?##??????"));

        //8. Enter phone number
        WebElement phoneNumberBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys(faker.numerify("571-###-####"));

        // 9. Select a gender from radio buttons (female)

        List<WebElement> genders = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));

        //click randomly number from 1 to 3 of the radio option
        for(int i = 1; i <=3; i++) {
            genders.get(faker.number().numberBetween(1, 3)).click();
        }

        // 10. Enter date of birth
        WebElement dateOfBirthBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));

        dateOfBirthBox.sendKeys("11/11/2000");

       //11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));

        departmentDropdown.selectByValue("DE");


       //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));

        jobTitleDropdown.selectByVisibleText("SDET");

       //13. Select programming language from checkboxes
        WebElement cCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='cplusplus']"));

        WebElement javaCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='java']"));

        WebElement javaScriptCheckbox= Driver.getDriver().findElement(By.xpath("//input[@value='javascript']"));

        javaCheckbox.click();

     //14. Click to sign up button
        WebElement signinBtn= Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));

        signinBtn.click();

     //15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement message = Driver.getDriver().findElement(By.xpath("//p"));

        String actualMessage = message.getText();
        System.out.println(actualMessage);

        Assert.assertEquals(actualMessage, "You've successfully completed registration!");

    }

}
/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.

1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.

Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense

 */
