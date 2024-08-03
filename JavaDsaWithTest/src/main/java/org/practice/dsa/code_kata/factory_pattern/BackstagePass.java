package org.practice.dsa.code_kata.factory_pattern;

public class BackstagePass extends Item {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        incrementQuality();
        if (sellIn < 11) {
            incrementQuality();
        }
        if (sellIn < 6) {
            incrementQuality();
        }
        decrementSellIn();
        if (sellIn < 0) {
            quality = 0;
        }
    }
}
