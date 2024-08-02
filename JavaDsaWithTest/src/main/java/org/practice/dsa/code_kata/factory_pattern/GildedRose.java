package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public class GildedRose {

    AbstractItems[] items;

    public GildedRose(Item[] items) {
        this.items = new AbstractItems[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = createItem(items[i]);
        }
    }

    public AbstractItems createItem(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(item);
            default -> new RegularItem(item);
        };
    }

    public void updateQuality() {
        for (AbstractItems item : items) {
            item.updateQuality();
        }
    }
}
