package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public class RegularItem extends AbstractItems {
    public RegularItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decrementQuality();
        decrementSellIn();
        if (item.sellIn < 0) {
            decrementQuality();
        }
    }
}
