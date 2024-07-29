package org.practice.dsa.code_kata;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!validateNames(i, "Aged Brie")
                    && !validateNames(i,"Backstage passes to a TAFKAL80ETC concert")) {
                removeQuantity(items,i,"Sulfuras, Hand of Ragnaros");
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (validateNames(i,"Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!validateNames(i,"Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!validateNames(i,"Aged Brie")) {
                    if (!validateNames(i,"Backstage passes to a TAFKAL80ETC concert")) {
                        removeQuantity(items,i, "Sulfuras, Hand of Ragnaros");
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
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