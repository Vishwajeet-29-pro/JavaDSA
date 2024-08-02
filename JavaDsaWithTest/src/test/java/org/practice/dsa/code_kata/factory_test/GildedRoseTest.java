package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.Item;
import org.practice.dsa.code_kata.factory_pattern.*;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseTest {
    private GildedRose gildedRose;

    @Test
    public void testCreateItem_AgedBrie() {
        Item[] items = {new Item("Aged Brie",10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(AgedBrie.class, abstractItems, "Expected an AgedBrie instance");
    }

    @Test
    public void testCreateItem_BackStagePass() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(BackstagePass.class, abstractItems, "Expected an BackstagePass instance");
    }

    @Test
    public void testCreateItem_Sulfuras() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(Sulfuras.class, abstractItems,"Expected an Sulfuras instance");
    }

    @Test
    public void testUpdateQuality_AgedBrie() {
        Item[] items = { new Item("Aged Brie", 2,0)};
        gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(1, items[0].sellIn, "SellIn should be decrement");
        assertEquals(1, items[0].quality, "Quality should be increment");
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
    public void testUpdateQuality_backstage_pass_if_item_quality_is_less_than_6() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(7, items[0].quality, "Quality should be increment");
        assertEquals(10, items[0].sellIn, "SellIn should be decrement");
    }

    @Test
    public void testUpdateQuality_backstage_pass_if_item_sellIn_is_than_0() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", -2,11)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(0, items[0].sellIn, "SellIn should be set to 0");
    }

    @Test
    public void testUpdateQuality_Sulfuras() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 10,11)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(10, items[0].sellIn,"Sell should be same");
        assertEquals(11, items[0].quality,"Quality should be same");
    }

    @Test
    public void testCreateItem_Regular() {
        Item[] items = { new Item("Regular Item",10,11)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(AbstractItems.class, abstractItems,"If no special item, then it should be Regular item");
    }

    @Test
    public void testUpdateQualityOnRegularItem() {
        Item[] items = { new Item("Regular item",10,11)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(10,items[0].quality,"Quality should be decrement");
        assertEquals(9, items[0].sellIn, "SellIn should be decrement");
    }
}
