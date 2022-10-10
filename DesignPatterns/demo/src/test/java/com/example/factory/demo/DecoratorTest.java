package com.example.factory.demo;

import com.example.factory.demo.Decorator.ChristmasTree;
import com.example.factory.demo.Decorator.ChristmasTreeImpl;
import com.example.factory.demo.Decorator.Decorators.BubbleLights;
import com.example.factory.demo.Decorator.Decorators.Tinsel;
import com.example.factory.demo.Decorator.Decorators.TreeTopper;
import org.junit.jupiter.api.Test;

public class DecoratorTest {
    @Test
    public void TestExample() {
        ChristmasTree tree2 = new TreeTopper(new BubbleLights(new Tinsel(new ChristmasTreeImpl())));
        System.out.println(tree2.decorate());
    }
}
