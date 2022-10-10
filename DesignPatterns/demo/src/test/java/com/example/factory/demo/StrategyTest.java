package com.example.factory.demo;

import com.example.factory.demo.Strategy.CreditCardStrategy;
import com.example.factory.demo.Strategy.Item;
import com.example.factory.demo.Strategy.PaypalStrategy;
import com.example.factory.demo.Strategy.ShoppingCart;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void Test1() {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("testEmail@randommailservice.com", "password"));

        cart.pay(new CreditCardStrategy("Eugen Segov", "1234567890123456", "786", "12/22"));
    }
}
