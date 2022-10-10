package com.example.factory.demo.Builder.Builder1;

import com.example.factory.demo.Builder.Builder1.Model.House;

public class CustomHouse {

    private String foundation = "Default";
    private String structure = "Default";
    private String roof = "Default";
    private boolean furnished;
    private boolean painted;

    public CustomHouse addFoundation (String foundation) {
        this.foundation = foundation;
        return this;
    }

    public CustomHouse addStructure (String structure) {
        this.structure = structure;
        return this;
    }

    public CustomHouse addRoof(String roof) {
        this.roof = roof;
        return this;
    }

    public CustomHouse isFurnished (boolean furnished) {
        this.furnished = furnished;
        return this;
    }

    public CustomHouse isPainted (boolean painted) {
        this.painted = painted;
        return this;
    }

    public House build() {
        House house = new House();
        house.setFoundation(foundation);
        house.setStructure(structure);
        house.setRoof(roof);
        house.setFurnished(furnished);
        house.setPainted(painted);

        return house;
    }

}
