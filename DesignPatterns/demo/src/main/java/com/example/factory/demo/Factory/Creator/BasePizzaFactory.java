package com.example.factory.demo.Factory.Creator;

import com.example.factory.demo.Factory.Product.Pizza;

public interface BasePizzaFactory {
    Pizza createPizza(String type);
}
