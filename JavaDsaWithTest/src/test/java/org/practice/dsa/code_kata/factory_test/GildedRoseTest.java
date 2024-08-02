package org.practice.dsa.code_kata.factory_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.code_kata.Item;
import org.practice.dsa.code_kata.factory_pattern.AbstractItems;
import org.practice.dsa.code_kata.factory_pattern.AgedBrie;
import org.practice.dsa.code_kata.factory_pattern.GildedRose;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseTest {
    private GildedRose gildedRose;

    @Test
    public void testCreateItem_AgedBrie() {
        Item[] items = {new Item("AgedBrie",10,20)};
        gildedRose = new GildedRose(items);

        AbstractItems abstractItems = gildedRose.createItem(items[0]);
        assertInstanceOf(AgedBrie.class, abstractItems, "Expected an AgedBrie instance");
    }
}
