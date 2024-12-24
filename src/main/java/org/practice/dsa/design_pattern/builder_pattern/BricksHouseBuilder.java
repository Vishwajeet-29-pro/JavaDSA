package org.practice.dsa.design_pattern.builder_pattern;

public class BricksHouseBuilder implements HouseBuilder {
    private House house;

    public BricksHouseBuilder(){
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete Foundation");
        System.out.println("BricksHouse Builder: Building Concrete Foundation...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Bricks Structure");
        System.out.println("BricksHouse Builder: Building Breaks Structure...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Concrete Roof");
        System.out.println("BricksHouse Builder: Building Concrete Roof...");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Bricks Interior");
        System.out.println("BricksHouse Builder: Building Breaks Interior...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
