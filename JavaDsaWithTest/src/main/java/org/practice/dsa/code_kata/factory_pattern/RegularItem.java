package org.practice.dsa.code_kata.factory_pattern;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        decrementQuality();
        decrementSellIn();
        if (sellIn < 0) {
            decrementQuality();
        }
    }
}
