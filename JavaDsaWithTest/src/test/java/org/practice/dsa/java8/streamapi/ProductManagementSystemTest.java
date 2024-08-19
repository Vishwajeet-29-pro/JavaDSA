package org.practice.dsa.java8.streamapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagementSystemTest {

    private List<Product> product;
    ProductManagementSystem system = new ProductManagementSystem();

    @BeforeEach
    public void setup() {
        product = new ArrayList<>();
        product.add(new Product("Computer", 50000, "Electronics"));
        product.add(new Product("Laptop", 50000, "Electronics"));
        product.add(new Product("Table", 20000, "Hardware"));
    }

    @Test
    public void testFilterProductsByCategory() {
        String category = "Electronics";
        List<Product> actualProduct = system.filterProductsByCategory(product, category);

        assertEquals(2, actualProduct.size());
        assertEquals("Computer", actualProduct.getFirst().getName());
    }

}