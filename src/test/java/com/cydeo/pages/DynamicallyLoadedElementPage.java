package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedElementPage {

public DynamicallyLoadedElementPage(){
    PageFactory.initElements(Driver.getDriver(), this);
//this: give access to all object/WebElement from this class to other classes
}

    @FindBy(xpath = "//button[.='Start']")
    public WebElement starBtn;

    @FindBy(css = "div#loading")
    public WebElement loadingBar;

    @FindBy(css = "#username")
    public WebElement inputUsernameBox;

    @FindBy(id = "pwd")
    public WebElement inputPasswordBox;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement errorMsg;

}
/*
TC#5 : Dynamically Loaded Page Elements 1
1. Go to https://practice.cydeo.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your password is invalid!” text is displayed.
 */