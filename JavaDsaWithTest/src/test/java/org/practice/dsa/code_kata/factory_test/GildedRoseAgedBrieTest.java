package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.Item;
import org.practice.dsa.code_kata.factory_pattern.*;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseAgedBrieTest {
    private GildedRose gildedRose;

    @Test
    public void testCreateItem_AgedBrie() {
        Item[] items = {new Item("Aged Brie",10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(AgedBrie.class, abstractItems, "Expected an AgedBrie instance");
    }

    @Test
    public void testUpdateQuality_AgedBrie() {
        Item[] items = { new Item("Aged Brie", 2,0)};
        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(1, items[0].sellIn, "SellIn should be decrement");
        assertEquals(1, items[0].quality, "Quality should be increment");
    }
}
