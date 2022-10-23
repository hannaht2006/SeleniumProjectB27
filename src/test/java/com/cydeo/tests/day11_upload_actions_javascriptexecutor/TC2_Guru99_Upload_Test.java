package com.cydeo.tests.day11_upload_actions_javascriptexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_Guru99_Upload_Test {

    @Test
    public void guru99_upload_test() {

// 1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.url"));

// 2. Upload file into Choose File
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("C:\\Users\\17038\\Downloads\\some-file.txt");//when we do automation, we don't click() on the chooseFile, we use SendKey()  //‪C:\Users\17038\Downloads\some-file.txt

//3. Click terms of service check box
        WebElement termOfService = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        termOfService.click();

//4. Click Submit File button
       WebElement submitFile = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
       submitFile.click();

//5. Verify expected message appeared.
// Expected:“1 file
// has been successfully uploaded.”
        WebElement resultMsg = Driver.getDriver().findElement(By.id("res"));

        String expectedMesg = "1 file\nhas been successfully uploaded.";
        //the message in 2 lines --> we  use "\n" to solve the issue

        String actualMesg = resultMsg.getText();
        BrowserUtils.sleep(1);

        Assert.assertEquals(actualMesg, expectedMesg);

    }
}
