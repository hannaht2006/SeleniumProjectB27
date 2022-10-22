package com.cydeo.tests.day8_webtable_utilities;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_WebTable_Practice extends TestBase {
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //1. Go to: https://practice.cydeo.com/web-tables
//        driver.get("https://practice.cydeo.com/web-tables");
//    }
    @Test
    public void order_name_verify_test(){
        //1. Go to: https://practice.cydeo.com/web-tables
       driver.get("https://practice.cydeo.com/web-tables");

       // 2. Verify Bob’s name is listed as expected.  Expected: “Bob Martin”
        WebElement bobMartinName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String expectedBobMartinName = "Bob Martin";
        String actualBobMartinName = bobMartinName.getText();
        System.out.println(actualBobMartinName);
        Assert.assertEquals(actualBobMartinName,expectedBobMartinName);

        //3. Verify Bob Martin’s order date is as expected . Expected: 12/31/2021
        WebElement bobOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));//go from child(td[.='Bob Martin']/..) to parent (tr) and then locate the element(day): "//td[.='Bob Martin']/../td[5]"

        Assert.assertEquals(bobOrderDate.getText(), "12/31/2021");
    }

    @Test
    public void test2(){ //using WebTableUtils method
        //1. Go to: https://practice.cydeo.com/web-tables
   driver.get("https://practice.cydeo.com/web-tables");
     String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

    }
    @Test
    public void test3(){
//1. Go to: https://practice.cydeo.com/web-tables
      driver.get("https://practice.cydeo.com/web-tables");
        WebTableUtils.orderVerify(driver, "Ned Stark", "05/12/2021");

    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
