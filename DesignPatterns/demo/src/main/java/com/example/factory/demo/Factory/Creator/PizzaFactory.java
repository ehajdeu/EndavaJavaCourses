package com.example.factory.demo.Factory.Creator;

import com.example.factory.demo.Factory.Product.CheesePizza;
import com.example.factory.demo.Factory.Product.ChiliPizza;
import com.example.factory.demo.Factory.Product.Pizza;

public class PizzaFactory implements BasePizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "chili":
                pizza = new ChiliPizza();
                break;
            default:
                throw new IllegalArgumentException("no such pizza");
        }
        pizza.bakePizza();
        return pizza;
    }
}
