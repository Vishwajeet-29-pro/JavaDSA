package org.practice.dsa.code_kata.factory_pattern;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        // Sulfuras never changes quality or sellIn
    }
}
