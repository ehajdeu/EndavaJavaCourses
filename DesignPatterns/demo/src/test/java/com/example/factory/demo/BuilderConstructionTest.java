package com.example.factory.demo;

import com.example.factory.demo.Builder.Builder1.Builders.HouseBuilder;
import com.example.factory.demo.Builder.Builder1.Builders.PrefabricatedHouseBuilder;
import com.example.factory.demo.Builder.Builder1.Construction;
import com.example.factory.demo.Builder.Builder1.CustomHouse;
import com.example.factory.demo.Builder.Builder1.Model.House;
import org.junit.jupiter.api.Test;

public class BuilderConstructionTest {
    @Test
    public void testConstructHouse() {
//        HouseBuilder prefabricatedHouse = new PrefabricatedHouseBuilder();
//        Construction engineerA = new Construction(prefabricatedHouse);
//        House houseA = engineerA.constructHouse();
//        System.out.println("House is: " + houseA);


        House testHouse = new CustomHouse()
                .addRoof("Wood")
                .addFoundation("Stone")
                .addStructure("Glass")
                .build();
        System.out.println(testHouse.toString());
    }
}
