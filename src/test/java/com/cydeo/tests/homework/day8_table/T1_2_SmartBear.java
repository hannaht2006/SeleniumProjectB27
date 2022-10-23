package com.cydeo.tests.homework.day8_table;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_2_SmartBear extends TestBase {
 @Test
 public void TC1_Smartbear() {
     //    2. Go to website:
//    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

//3. Enter username: “Tester”
     WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
     userName.sendKeys("Tester");

     BrowserUtils.sleep(1);

     //4. Enter password: “test”
     WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
     password.sendKeys("test");
     BrowserUtils.sleep(1);

     //5. Click to Login button
     WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
     loginBtn.click();

     //6. Print out count of all the links on landing page
     List<WebElement> links = driver.findElements(By.tagName("a"));
     int numberOfLinks = links.size();
     System.out.println("numberOfLinks = " + numberOfLinks);

     //7. Print out each link text on this page
     for (WebElement eachLink : links) {
         System.out.println(eachLink.getText());
     }
 }

     @Test
     public void Test_SmartBearUtils(){
//    2. Go to website:
//    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
         driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
         SmartBearUtils.loginToSmartBear(driver, "Tester", "test");
     }

     @Test
    public void TC2_OrderPlace(){
     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

     SmartBearUtils.loginToSmartBear(driver, "Tester", "test");

     //6. Click on Order
     WebElement orderBtn = driver.findElement(By.xpath("//a[.='Order']"));
     orderBtn.click();

     //7. Select familyAlbum from product, set quantity to 2
         Select productDropdown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
         productDropdown.selectByVisibleText("FamilyAlbum");

         WebElement qualityBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
         qualityBtn.sendKeys("2");

         //8. Click to “Calculate” button
         WebElement calculateBtn = driver.findElement(By.xpath("//input[@value='Calculate']"));
         calculateBtn.click();

         //9. Fill address Info with JavaFaker
//         • Generate: name, street, city, state, zip code
         Faker faker = new Faker();

         WebElement nameBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
         nameBtn.sendKeys(faker.name().fullName());

         WebElement streetBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
         streetBtn.sendKeys(faker.address().streetAddress());

         WebElement cityBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
         cityBtn.sendKeys(faker.address().cityName());

         WebElement stateBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
         stateBtn.sendKeys(faker.address().state());

         WebElement zipCodeBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
         zipCodeBtn.sendKeys(faker.address().zipCode());

//         10. Click on “visa” radio button
          WebElement visaBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
          visaBtn.click();

//         11. Generate card number using JavaFaker
         WebElement cardBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
         cardBtn.sendKeys(faker.finance().creditCard());

         WebElement dateBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
         dateBtn.sendKeys(faker.numerify("##/##"));

//         12. Click on “Process”
         WebElement processBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
         processBtn.click();

//         13. Verify success message “New order has been successfully added.”
          WebElement message = driver.findElement(By.xpath("//strong   "));
          String actualMessage = message.getText();
          String expectedMessage = "New order has been successfully added.";

         Assert.assertEquals(actualMessage,expectedMessage);
     }

     @Test
    public void TC3_SmartbearSoftwareOrderVerification(){

         driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

         SmartBearUtils.loginToSmartBear(driver, "Tester", "test");

        //2. Click on View all orders
         WebElement viewAllOrderBtn = driver.findElement(By.xpath("//a[.='View all orders']"));

         //3. Verify Susan McLaren has order on date “01/05/2010”
         WebElement susanOrderDateBtn = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
         Assert.assertEquals(susanOrderDateBtn.getText(),"01/05/2010");

     }




    /*
    TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page

Mini-Task: CREATE A CLASS à SmartBearUtils
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter

TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”



TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”

     */
}
