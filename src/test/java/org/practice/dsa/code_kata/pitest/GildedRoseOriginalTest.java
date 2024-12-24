package org.practice.dsa.code_kata.pitest;

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
    void testHandleExpiredItemForNormalItem() {
        // Test normal item just before expiration
        Item normalItem = new Item("Normal Item", 0, 10);
        normalItem.updateQuality();
        assertEquals(8, normalItem.quality, "Quality should decrease by 2 when sellIn is 0");

        // Test normal item after expiration
        normalItem = new Item("Normal Item", -1, 10);
        normalItem.updateQuality();  // Call updateQuality() for this case as well
        assertEquals(8, normalItem.quality, "Quality should decrease by 2 when sellIn < 0");
    }


    @Test
    void testUpdateQualityForAgedBrie() {
        Item agedBrie = new Item("Aged Brie",2, 0);
        agedBrie.updateQuality();
        assertEquals(1, agedBrie.sellIn, "SellIn should be decrease by 1");
        assertEquals(1, agedBrie.quality, "Quality should increase by 1");
    }

    @Test
    void testUpdateQualityForAgedBrie_SellIn_less_than_zero() {
        Item agedBrie = new Item("Aged Brie",-1,11);
        agedBrie.updateQuality();
        assertEquals(13, agedBrie.quality, "Quality should be decrease by 1");
    }

    @Test
    void testUpdateQualityForAgedBrie_SellIn_is_zero() {
        Item agedBrie = new Item("Aged Brie",0,11);
        agedBrie.updateQuality();
        assertEquals(13, agedBrie.quality, "Quality should be decrease by 1");
    }

    @Test
    void testUpdateQuality() {
        Item regular = new Item("Regular item", -1, 11);
        regular.updateQuality();
        assertEquals(9, regular.quality);
    }

    @Test
    void testUpdateQualityForBackstagePasses() {
        // Test with sellIn at exact boundary of 11 days
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        backstagePass.updateQuality();
        assertEquals(21, backstagePass.quality, "Quality should be increased by 1 when sellIn is 11");

        // Test with sellIn at exact boundary of 10 days
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        backstagePass.updateQuality();
        assertEquals(22, backstagePass.quality, "Quality should increase by 2 when sellIn is 10");

        // Test with sellIn at exact boundary of 6 days
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        backstagePass.updateQuality();
        assertEquals(22, backstagePass.quality, "Quality should increase by 2 when sellIn is 6");

        // Test with sellIn at exact boundary of 5 days
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        backstagePass.updateQuality();
        assertEquals(23, backstagePass.quality, "Quality should increase by 3 when sellIn is 5");
    }

    @Test
    void testUpdateQualityForBackstagePassesEdgeCases() {
        // Test with sellIn at boundary and quality nearing max
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49);
        backstagePass.updateQuality();
        assertEquals(50, backstagePass.quality, "Quality should not exceed 50 when sellIn is 11");

        // Test with sellIn at boundary and quality nearing max
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        backstagePass.updateQuality();
        assertEquals(50, backstagePass.quality, "Quality should not exceed 50 even when sellIn is 5");
    }

    @Test
    void testUpdateQualityForExpiredBackstagePass() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        backstagePass.updateQuality();
        assertEquals(0, backstagePass.quality, "Quality should drop to 0 after concert");

        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        backstagePass.updateQuality();
        assertEquals(0, backstagePass.quality, "Quality should remain 0 after the concert has passed");
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

    @Test
    void testToString() {
        Item item = new Item("Item", 10, 20);
        String result = item.toString();
        assertEquals("Item, 10, 20", result);
    }
}
