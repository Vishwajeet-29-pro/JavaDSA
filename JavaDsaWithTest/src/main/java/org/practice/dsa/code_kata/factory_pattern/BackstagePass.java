package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public class BackstagePass extends AbstractItems {
    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        incrementQuality();
        if (item.quality < 11) {
            incrementQuality();
        }
        if (item.quality < 6) {
            incrementQuality();
        }
        decrementSellIn();
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
    }
}
