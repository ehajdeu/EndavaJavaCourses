package com.example.factory.demo.Builder.Builder1.Builders;

import com.example.factory.demo.Builder.Builder1.Model.House;

public interface HouseBuilder {
    void buildFoundation();

    void buildStructure();

    void buildRoof();

    void paintHouse();

    void furnishHouse();

    House getHouse();
}
