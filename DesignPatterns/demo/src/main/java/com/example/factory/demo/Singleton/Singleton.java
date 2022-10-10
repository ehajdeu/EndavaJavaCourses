package com.example.factory.demo.Singleton;

public class Singleton {
    private static Singleton instance;
    public String value;

    //make the constructor private so that this class cannot be
    //instantiated
    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
}
