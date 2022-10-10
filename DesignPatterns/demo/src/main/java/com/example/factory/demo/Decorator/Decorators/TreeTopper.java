package com.example.factory.demo.Decorator.Decorators;

import com.example.factory.demo.Decorator.ChristmasTree;

public class TreeTopper extends TreeDecorator {

    public TreeTopper(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithTreeTopper();
    }

    private String decorateWithTreeTopper() {
        return " with TreeTopper";
    }
}
