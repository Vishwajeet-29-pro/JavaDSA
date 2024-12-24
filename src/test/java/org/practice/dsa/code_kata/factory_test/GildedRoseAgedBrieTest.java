package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.factory_pattern.*;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseAgedBrieTest {

    @Test
    public void testCreateItem_AgedBrie() {
        Item item = Item.newItem("Aged Brie", 10, 20);
        assertInstanceOf(AgedBrie.class, item, "Expected an AgedBrie instance");
    }

    @Test
    public void testUpdateQuality_AgedBrie() {
        Item[] items = { Item.newItem("Aged Brie", 2, 0) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(1, items[0].sellIn, "SellIn should be decremented");
        assertEquals(1, items[0].quality, "Quality should be incremented");
    }
}
