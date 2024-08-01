package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public class AgedBrie extends AbstractItems{
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        incrementQuality();
        decrementSellIn();
        if (item.sellIn < 0) {
            incrementQuality();
        }
    }
}
