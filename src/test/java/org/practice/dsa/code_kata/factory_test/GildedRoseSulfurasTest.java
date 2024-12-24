package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.factory_pattern.Item;
import org.practice.dsa.code_kata.factory_pattern.GildedRose;
import org.practice.dsa.code_kata.factory_pattern.Sulfuras;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseSulfurasTest {

    @Test
    public void testCreateItem_Sulfuras() {
        Item item = Item.newItem("Sulfuras, Hand of Ragnaros", 10, 20);
        assertInstanceOf(Sulfuras.class, item, "Expected a Sulfuras instance");
    }

    @Test
    public void testUpdateQuality_Sulfuras() {
        Item[] items = { Item.newItem("Sulfuras, Hand of Ragnaros", 10, 11) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(10, items[0].sellIn, "SellIn should remain the same");
        assertEquals(11, items[0].quality, "Quality should remain the same");
    }
}
