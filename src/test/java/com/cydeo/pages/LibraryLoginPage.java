package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //create constructor:
    public LibraryLoginPage(){
        /*
        PageFactory class is a selenium class that support POM
        it has method called initElements. once it's called it will store all elements specified using @FindBy annotation with locator and it will give elements to the class when they called

        initElements method accept 2 arguments :
        - WebDriver instance and Page class instance(this) means current instance of this class
         */
       PageFactory.initElements(Driver.getDriver(),this);// if you don't have this line, when you run test case , will throw nullPointException

    }

//located WebElement by @FindBy annotation
    // to make these WebElements below to be accessible from test class --> use public keyword

    @FindBy(id = "inputEmail")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy (xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath = "//div[.='This field is required.']")
    public WebElement fieldRequiredErrorMsg;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterInvalidEmailErrorMsg;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailAndPasswordErrorMsg;


    //extra explanation to understand the argument "this" :
//    int num;
//    public void testing(int anothernum){
//        this.num = anothernum;
//    }

}
/*
TC#1
1- Open a chrome browser
2- Go to: https://library1.cydeo.com/
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
 */