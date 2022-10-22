package com.cydeo.tests.homework.day8_table;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest extends TestBase {
/*
1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”
 */
@Test
    public void Search(){
    //2. Go to https://www.calculator.net
    driver.get("https://www.calculator.net");

    //3. Search for “gas mileage” using search box
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
    searchBox.sendKeys("gas mileage");

//    WebElement searchBtn = driver.findElement(By.xpath("//span[@id='bluebtn']"));
//    searchBtn.click();

    //4. Click on the “Gas Mileage Calculator” link
    WebElement gasMileageLink = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
    gasMileageLink.click();

    //5. On Next page verify:
    //a. Title equals: “Gas Mileage Calculator”
    //b. “Gas Mileage Calculator” label is displayed
    BrowserUtils.sleep(2);
    String actualNewPageTitle = driver.getTitle();
    Assert.assertEquals(actualNewPageTitle,"Gas Mileage Calculator");

    WebElement lableGasMileage = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));
    Assert.assertEquals(lableGasMileage.getText(),"Gas Mileage Calculator");

    //6. Locate, clear and type “7925” into “Current odometer” field
    WebElement currentOdometer = driver.findElement(By.xpath("//input[@id='uscodreading']"));
    currentOdometer.clear();
    currentOdometer.sendKeys("7925");

    //7. Locate, clear and type “7550” into “Previous odometer” field
    WebElement previousOdometer = driver.findElement(By.xpath("//input[@id='uspodreading']"));
    previousOdometer.clear();
    previousOdometer.sendKeys("7550");

    //8. Locate, clear and type “16” into “Gas added” field
    WebElement gasAdded = driver.findElement(By.xpath("//input[@id='usgasputin']"));
    gasAdded.clear();
    gasAdded.sendKeys("16");

    //9. Locate, clear and type “3.55” into “Gas price” field
    WebElement gasPrice =driver.findElement(By.xpath("//input[@id='usgasprice']"));
    gasPrice.clear();
    gasPrice.sendKeys("3.55");

    //10. Click on Calculate button
WebElement calculateBtn = driver.findElement(By.xpath("//table[@id='standard']//input[@alt='Calculate']"));
calculateBtn.click();

    //11. Verify mpg value is as expected:
    //Expected value: “23.44 mpg”
WebElement mpgValue = driver.findElement(By.xpath("(//div[@id='content']//b)[1]"));

Assert.assertEquals(mpgValue.getText(), "23.44 mpg");
}
}
