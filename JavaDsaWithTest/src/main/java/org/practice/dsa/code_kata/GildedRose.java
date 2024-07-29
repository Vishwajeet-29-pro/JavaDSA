package org.practice.dsa.code_kata;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!validateNames(i, itemsNameMap().get("a"))
                    && !validateNames(i, itemsNameMap().get("b"))) {
                removeQuantity(items, i, itemsNameMap().get("c"));
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (validateNames(i,itemsNameMap().get("b"))) {
                        if (items[i].sellIn < 11) {
                            addQuality(items, i);
                        }

                        if (items[i].sellIn < 6) {
                            addQuality(items, i);
                        }
                    }
                }
            }

            if (!validateNames(i,itemsNameMap().get("b"))) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!validateNames(i,itemsNameMap().get("a"))) {
                    if (!validateNames(i,itemsNameMap().get("b"))) {
                        removeQuantity(items, i, itemsNameMap().get("c"));
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    addQuality(items, i);
                }
            }
        }
    }

    public Map<String, String> itemsNameMap() {
        Map<String, String> itemNameMap = new HashMap<>();
        itemNameMap.put("a","Aged Brie");
        itemNameMap.put("b","Backstage passes to a TAFKAL80ETC concert");
        itemNameMap.put("c","Sulfuras, Hand of Ragnaros");

        return itemNameMap;
    }

    public void addQuality(Item[] items, int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    public void removeQuantity(Item[] items, int i, String itemName) {
        if (items[i].quality > 0) {
            if (!validateNames(i,itemName)) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public boolean validateNames(int i, String itemName) {
        return items[i].name.equals(itemName);
    }
}