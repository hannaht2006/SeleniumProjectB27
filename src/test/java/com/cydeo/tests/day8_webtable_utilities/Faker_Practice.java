package com.cydeo.tests.day8_webtable_utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Faker_Practice {

    @Test
    public void FakerTest(){
        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println(faker.address().cityName());
        System.out.println("faker.numerify(\"703-###-####\") = " + faker.numerify("703-###-####"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

    }
}
