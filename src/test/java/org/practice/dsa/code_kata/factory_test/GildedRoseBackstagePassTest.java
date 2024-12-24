package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.factory_pattern.BackstagePass;
import org.practice.dsa.code_kata.factory_pattern.GildedRose;
import org.practice.dsa.code_kata.factory_pattern.Item;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseBackstagePassTest {

    @Test
    public void testCreateItem_BackStagePass() {
        Item item = Item.newItem("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        assertInstanceOf(BackstagePass.class, item, "Expected a BackstagePass instance");
    }

    @Test
    public void testUpdateQuality_BackstagePass() {
        Item[] items = { Item.newItem("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(11, items[0].quality, "Quality should increment by 1");
        assertEquals(10, items[0].sellIn, "SellIn should decrement");
    }

    @Test
    void testUpdateQuality_BackstagePass_FiveDaysOrLess() {
        Item[] items = { Item.newItem("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(13, items[0].quality, "Quality should increment by 3");
        assertEquals(4, items[0].sellIn, "SellIn should decrement");
    }

    @Test
    public void testUpdateQuality_Backstage_pass_if_item_sellIn_is_than_0() {
        Item[] items = { Item.newItem("Backstage passes to a TAFKAL80ETC concert", -2, 11) };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, items[0].quality, "Quality should be set to 0");
        assertEquals(-3, items[0].sellIn, "SellIn should decrement");
    }
}
