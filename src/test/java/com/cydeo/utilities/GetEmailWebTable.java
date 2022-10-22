package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetEmailWebTable {

    public static void getTableGetEmail(WebDriver driver, String tableNum,String firstName) {
        WebElement emailAtTable = driver.findElement(By.xpath("//table[@id='"+tableNum+"']//td[.='"+ firstName+"']/following-sibling::td[1]"));
        String email = emailAtTable.getText();
        System.out.println(email);
    }
}
/*
3- Write custom method:

• Method name: getTableGetEmail()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String tableNum
• Arg3: String firstName
 */