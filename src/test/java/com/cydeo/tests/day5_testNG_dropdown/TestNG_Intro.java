package com.cydeo.tests.day5_testNG_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @Test(priority = 2)
    public void test1(){
        System.out.println("test1 is running...");
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);//choose Assert from testng
    }
    @Test (priority = 1)
    public void test2(){
        System.out.println("test2 is running....");

        String actual = "apple";
        String expected = "apple2";
        Assert.assertTrue(actual.equals(expected));
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> Before Method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method is running");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("--> Before Class is running...");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }
}
