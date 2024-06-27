package com.practice.dsa.design_pattern.builder_pattern;

public class BuilderPatternTest {
    public static void main(String[] args) {
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        ConstructionEngineer engineer = new ConstructionEngineer(woodenHouseBuilder);
        House woodenHouse = engineer.constructHouse();
        System.out.println("House is: "+woodenHouse);

        HouseBuilder bricksHouseBuilder = new BricksHouseBuilder();
        engineer = new ConstructionEngineer(bricksHouseBuilder);
        House bricksHouse = engineer.constructHouse();
        System.out.println("House is: "+bricksHouse);
    }
}
