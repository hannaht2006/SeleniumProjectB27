package com.cydeo.tests.day10_javafaker_driver_util;

public class Singleton {

    //1. create private constructor
    private Singleton (){
    }

    //create private static String
    //prevent access and provide a getter method
    private static String word; // word here is null(no value)

    //this utility method will return the "word" in the way we want to return
    public static String getWord(){
     if(word==null)   {
         System.out.println("first time call. word object is null. we will assign the value now");
         word = "something";
     }else{
         System.out.println("word already has value");

     }
     return word;
    }
}
