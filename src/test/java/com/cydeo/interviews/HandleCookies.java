package com.cydeo.interviews;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleCookies {
    @Test
    public void cookiesHandlingTest(){
        Driver.getDriver().get("https://cookie-script.com/");
        Set<Cookie> cookies =  Driver.getDriver().manage().getCookies();
        System.out.println("cookies = " + cookies);
        System.out.println("cookies.size() = " + cookies.size());
        Driver.getDriver().manage().deleteAllCookies();
        cookies =  Driver.getDriver().manage().getCookies();
        System.out.println("cookies = " + cookies);
        System.out.println("cookies.size() = " + cookies.size());

    }
}
