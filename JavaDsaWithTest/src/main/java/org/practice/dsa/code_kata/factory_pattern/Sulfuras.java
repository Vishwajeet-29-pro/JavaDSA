package org.practice.dsa.code_kata.factory_pattern;

import org.practice.dsa.code_kata.Item;

public class Sulfuras extends AbstractItems {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        // Sulfuras never changes quality or sellIn
    }
}
