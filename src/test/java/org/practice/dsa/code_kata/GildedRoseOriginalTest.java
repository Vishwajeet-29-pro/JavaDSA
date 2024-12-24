package org.practice.dsa.code_kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseOriginalTest {

    @Test
    void testUpdateQualityForNormalItem() {
        Item normalItem = new Item("Normal Item", 10, 20);
        normalItem.updateQuality();
        assertEquals(19, normalItem.quality, "Quality should decrease by 1");
        assertEquals(9, normalItem.sellIn, "SellIn should decrease by 1");
    }

    @Test
    void testUpdateQualityForAgedBrie() {
        Item agedBrie = new Item("Aged Brie",2, 0);
        agedBrie.updateQuality();
        assertEquals(1, agedBrie.sellIn, "SellIn should be decrease by 1");
        assertEquals(1, agedBrie.quality, "Quality should increase by 1");
    }

    @Test
    void testUpdateQualityForBackstagePasses() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        backstagePass.updateQuality();
        assertEquals(21, backstagePass.quality, "Quality should be increased by 1");

        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        backstagePass.updateQuality();
        assertEquals(22, backstagePass.quality, "Quality should increase by 2 when sellIn < 11");

        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        backstagePass.updateQuality();
        assertEquals(23, backstagePass.quality, "Quality should increase by 3 when sellIn < 6");
    }
    @Test
    void testUpdateQualityForExpiredBackstagePass() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        backstagePass.updateQuality();
        assertEquals(0, backstagePass.quality, "Quality should drop to 0 after concert");
    }

    @Test
    void testUpdateQualityForSulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        sulfuras.updateQuality();
        assertEquals(80, sulfuras.quality, "Quality should remain the same for Sulfuras");
        assertEquals(0, sulfuras.sellIn, "SellIn should remain the same for Sulfuras");
    }

    @Test
    void testQualityDoesNotBecomeNegative() {
        Item normalItem = new Item("Normal Item", 10, 0);
        normalItem.updateQuality();
        assertEquals(0, normalItem.quality, "Quality should not become negative");
    }

    @Test
    void testQualityDoesNotExceedFifty() {
        Item agedBrie = new Item("Aged Brie", 10, 50);
        agedBrie.updateQuality();
        assertEquals(50, agedBrie.quality, "Quality should not exceed 50");
    }
}
