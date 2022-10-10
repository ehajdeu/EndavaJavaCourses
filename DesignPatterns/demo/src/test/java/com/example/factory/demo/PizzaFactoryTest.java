package com.example.factory.demo;

import com.example.factory.demo.Factory.Creator.BasePizzaFactory;
import com.example.factory.demo.Factory.Creator.PizzaFactory;
import com.example.factory.demo.Factory.Product.Pizza;
import org.junit.jupiter.api.Test;

public class PizzaFactoryTest {

    @Test
    public void testMakePizzas(){
        BasePizzaFactory pizzaFactory = new PizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        Pizza chiliPizza = pizzaFactory.createPizza("chili");
    }

}
