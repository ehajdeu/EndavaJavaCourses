package com.example.factory.demo.Factory.Product;

public class ChiliPizza implements Pizza {

    @Override
    public void bakePizza() {
        System.out.println("Baking hot chili pizza");
    }
}
