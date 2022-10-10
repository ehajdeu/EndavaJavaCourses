package com.example.factory.demo;

import com.example.factory.demo.Singleton.Singleton;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance("Compu");
        Singleton singleton1 = Singleton.getInstance("Dava");
        System.out.println(singleton.value);
        System.out.println(singleton1.value);
    }
}
