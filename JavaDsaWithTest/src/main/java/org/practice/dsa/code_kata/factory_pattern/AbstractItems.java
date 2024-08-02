package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public abstract class AbstractItems {

    Item item;

    public AbstractItems(Item item) {
        this.item = item;
    }

    abstract void updateQuality();

    protected void incrementQuality() {
        if (item.quality < 50 ) item.quality++;
    }

    protected void decrementQuality() {
        if (item.quality > 0) item.quality -=1;
    }

    protected void decrementSellIn() {
        item.sellIn -= 1;
    }

}
