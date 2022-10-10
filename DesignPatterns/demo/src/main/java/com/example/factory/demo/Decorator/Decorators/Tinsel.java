package com.example.factory.demo.Decorator.Decorators;

import com.example.factory.demo.Decorator.ChristmasTree;

public class Tinsel extends TreeDecorator {

    public Tinsel(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithTinsel();
    }

    private String decorateWithTinsel() {
        return " with Tinsel";
    }
}
