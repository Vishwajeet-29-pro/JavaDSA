package org.practice.dsa.code_kata.factory_pattern;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        incrementQuality();
        decrementSellIn();
        if (sellIn < 0) {
            incrementQuality();
        }
    }
}
