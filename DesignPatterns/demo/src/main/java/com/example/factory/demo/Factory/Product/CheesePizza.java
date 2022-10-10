package com.example.factory.demo.Factory.Product;

public class CheesePizza implements Pizza {

    @Override
    public void bakePizza() {
        System.out.println("Baking Cheese Pizza");
    }
}
