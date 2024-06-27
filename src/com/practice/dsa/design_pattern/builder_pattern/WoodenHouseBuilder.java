package com.practice.dsa.design_pattern.builder_pattern;

public class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder(){
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Wooden Foundation");
        System.out.println("WoodenHouseBuilder: Building Wooden foundation...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wooden Structure");
        System.out.println("WoodenHouseBuilder: Building Wooden Structure...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wooden Roof");
        System.out.println("WoodenHouseBuilder: Building Wooden Roof...");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Wooden Interior");
        System.out.println("WoodenHouseBuilder: Building Wooden Interior...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
