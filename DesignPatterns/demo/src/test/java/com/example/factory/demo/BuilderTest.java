package com.example.factory.demo;

import com.example.factory.demo.Builder.Builder2.User;
import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    void testBuilder1() {
        User user1 = new User.UserBuilder("FirstName1", "LastName1")
                .age(22)
                .phone("123456")
                .address("Address 1")
                .build();
        System.out.println(">>>> " + user1);
    }

    @Test
    void testBuilder2() {
        User user2 = new User.UserBuilder("FirstName2", "LastName2")
                .age(27)
                .phone("654321")
                //no address
                .build();
        System.out.println(">>>> " + user2);
    }

    @Test
    void testBuilder3() {
        User user3 = new User.UserBuilder("FirstName3", "LastName3")
                //no age
                //no phone
                //no address
                .build();
        System.out.println(">>>> " + user3);
    }
}
