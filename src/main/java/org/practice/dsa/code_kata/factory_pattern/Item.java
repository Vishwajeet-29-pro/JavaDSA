package org.practice.dsa.code_kata.factory_pattern;

public abstract class Item {
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract void updateQuality();

    protected void incrementQuality() {
        if (quality < 50 ) quality++;
    }

    protected void decrementQuality() {
        if (quality > 0) quality -=1;
    }

    protected void decrementSellIn() {
        sellIn -= 1;
    }

    public static Item newItem(String name, int sellIn, int quality) {
        return switch (name) {
            case "Aged Brie" -> new AgedBrie(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(name, sellIn, quality);
            default -> new RegularItem(name, sellIn, quality);
        };
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
