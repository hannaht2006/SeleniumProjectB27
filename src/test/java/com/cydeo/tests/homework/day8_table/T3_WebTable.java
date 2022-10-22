package com.cydeo.tests.homework.day8_table;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.GetEmailWebTable;
import org.testng.annotations.Test;

public class T3_WebTable extends TestBase {
    //TC #3: Create a custom method
    //1- Open a chrome browser
    @Test
    public void T8_Table_mail(){

        //2- Go to: https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        GetEmailWebTable.getTableGetEmail(driver, "table1", "Jason");
    }
    /*
3- Write custom method:

• Method name: getTableGetEmail()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String tableNum
• Arg3: String firstName
     */
}
