package com.cydeo.tests.day9_properties_configuration_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC1_LoginSenarios  {

    //1. Create new test with Driver.getDriver()
    @Test
    public void crm_login_test(){

//2. Go to : http://login1.nextbasecrm.com/
        Driver.getDriver().get("http://login1.nextbasecrm.com/");

//3. Enter valid username //hr2@cydeo.com
        WebElement userNameBtn =   Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameBtn.sendKeys("hr2@cydeo.com");

//4. Enter valid password
WebElement passwordBtn =   Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
passwordBtn.sendKeys("UserUser");

//5. Click to Log In button

        WebElement loginBtn =   Driver.getDriver().findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

//6. Verify title is as expected:
//Expected: Portal
        BrowserUtils.verifyTitle( "Portal" );
    }

@Test
    public void crm_login_test_2(){

    Driver.getDriver().get("http://login1.nextbasecrm.com/");
    CRM_Utilities.login_crm(Driver.getDriver());
    BrowserUtils.verifyTitle("Portal");
}

@Test
public void crm_login_test_3()  {
    Driver.getDriver().get("http://login1.nextbasecrm.com/");
    CRM_Utilities.login_crm(Driver.getDriver(), "hr3@cydeo.com","UserUser");
    System.out.println(Driver.getDriver().getTitle());

    BrowserUtils.sleep(2);

    //verification of title is failing sametimes; it's a bug
    BrowserUtils.verifyTitle( "Portal");
}


}
