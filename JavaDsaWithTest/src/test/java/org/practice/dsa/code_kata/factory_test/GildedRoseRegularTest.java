package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.factory_pattern.Item;
import org.practice.dsa.code_kata.factory_pattern.GildedRose;
import org.practice.dsa.code_kata.factory_pattern.RegularItem;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseRegularTest {

    @Test
    public void testCreateItem_Regular() {
        Item item = Item.newItem("Regular Item", 10, 11);
        assertInstanceOf(RegularItem.class, item, "Expected a RegularItem instance");
    }

    @Test
    public void testUpdateQualityOnRegularItem() {
        Item[] items = { Item.newItem("Regular Item", 10, 11) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(10, items[0].quality, "Quality should decrement");
        assertEquals(9, items[0].sellIn, "SellIn should decrement");
    }

    @Test
    public void testUpdatedQuality_RegularItem_Expired() {
        Item[] items = { Item.newItem("Regular Item", 0, 10) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(-1, items[0].sellIn, "SellIn should decrement");
        assertEquals(8, items[0].quality, "Quality should decrement by 2");
    }
}
