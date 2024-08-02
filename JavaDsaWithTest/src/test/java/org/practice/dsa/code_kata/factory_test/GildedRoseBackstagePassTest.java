package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.Item;
import org.practice.dsa.code_kata.factory_pattern.AbstractItems;
import org.practice.dsa.code_kata.factory_pattern.BackstagePass;
import org.practice.dsa.code_kata.factory_pattern.GildedRose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class GildedRoseBackstagePassTest {

    private GildedRose gildedRose;


    @Test
    public void testCreateItem_BackStagePass() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(BackstagePass.class, abstractItems, "Expected an BackstagePass instance");
    }

    @Test
    public void testUpdateQuality_BackstagePass() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 11,10)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(11, items[0].quality, "Quality should be increment");
        assertEquals(10, items[0].sellIn, "SellIn should be decrement");
    }

    @Test
    void testUpdateQuality_BackstagePass_FiveDaysOrLess() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(4, items[0].sellIn, "SellIn should decrement");
        assertEquals(13, items[0].quality, "Quality should increment by 3");
    }

    @Test
    public void testUpdateQuality_Backstage_pass_if_item_sellIn_is_than_0() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", -2,11)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(-3, items[0].sellIn, "SellIn should decrement");
        assertEquals(0, items[0].quality, "Quality should be set to 0");
    }
}
