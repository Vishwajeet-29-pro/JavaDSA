package org.practice.dsa.code_kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
    GildedRose app = new GildedRose(items);
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void validateItemsName() {
        String itemName = "Aged Brie";

        var result = app.validateNames(0, itemName);
        assertTrue(result);
        var result2 = app.validateNames(0, "foo");
        assertFalse(result2);
    }

    @Test
    void when_items_price_greater_than_zero_reduce_quantity_by_one() {
        String itemName = "foo";
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        app.removeQuantity(items,0, itemName);
        assertEquals(0, items[0].quality);
    }
}