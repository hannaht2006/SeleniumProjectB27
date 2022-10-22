package com.cydeo.utilities;

// TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){//set the method is static for later to call the method by just call the class name
     if(browserType.equalsIgnoreCase("chrome")){
         WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();
         //return driver;
        return new ChromeDriver();

     }else if (browserType.equalsIgnoreCase("firefox")){
         WebDriverManager.firefoxdriver().setup();
         return new FirefoxDriver();

     }else{
         System.out.println("Given browser type doesn't exist/or not currrently supported");
        return null;
     }

    }
}
