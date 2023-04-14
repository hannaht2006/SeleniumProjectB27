package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetSpeedPage {

    public InternetSpeedPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
//if you have white spaces in your locator's content(text) in HTML, you use"normalize-space()" for text of elements
    @FindBy(xpath = "//a[normalize-space()='Results']")
    public WebElement resultLink;

    @FindBy(xpath = "//span[.='Go']")
    public WebElement goBtn;

    @FindBy(className = "gauge-speed-text")
    public WebElement gaugeSpeedNeedle;

    @FindBy(xpath = "//span[@class='result-data-large number result-data-value download-speed']")
    public WebElement downloadSpeed;

//if you use css for finding element: if there are space between words---> replace space with ".", the css will work (look at the below example)
    @FindBy(css = ".result-data-large.number.result-data-value.upload-speed")
    public WebElement uploadSpeed;

}
/*
TC #2: Explicit wait practice
1- Open a chrome browser

2- Go to: https://www.speedtest.net/
3- Wait until Results link is displayed
4- Click on Go button
5- Wait until gauge-speed-needle displayed
6- Wait until gauge-speed-needle disappear
7- Print Download and Upload Speeds
 */