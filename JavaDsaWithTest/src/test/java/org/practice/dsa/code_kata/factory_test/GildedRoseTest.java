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
}
