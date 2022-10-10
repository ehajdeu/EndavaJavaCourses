package com.example.factory.demo.Decorator.Decorators;

import com.example.factory.demo.Decorator.ChristmasTree;

public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
