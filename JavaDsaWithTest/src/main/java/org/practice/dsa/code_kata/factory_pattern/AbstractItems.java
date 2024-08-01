package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

abstract class AbstractItems {

    Item item;

    public AbstractItems(Item item) {
        this.item = item;
    }

    abstract void updateQuality();

    public void incrementQuality() {
        if (item.quality < 50 ) item.quality++;
    }

    public void decrementQuality() {
        if (item.quality > 0) item.quality -=1;
    }

    public void decrementSellIn() {
        item.sellIn -= 1;
    }

}
