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

    @Test
    public void testSortProductByPrice() {
        List<Product> productList = system.sortProductByPrice(product);
        assertEquals("Table", productList.getFirst().getName());
        assertEquals(20000, productList.getFirst().getPrice());
    }

    @Test
    public void testMostExpensiveProduct() {
        List<Product> expensiveProducts = system.mostExpensiveProduct(product);
        assertEquals(50000, expensiveProducts.getFirst().getPrice());
    }

    @Test
    public void testGetAveragePriceFromCategory() {
        String category = "Electronics";
        double price = system.getAveragePriceFromCategory(product, category);
        assertEquals(50000, price);
    }

    @Test
    public void testGetNamesOfAllProduct() {
        List<String> expectedNames = List.of(product.getFirst().getName(), product.get(1).getName(), product.getLast().getName());
        List<String> actualNames = system.getNameOfAllProducts(product);
        assertEquals(expectedNames, actualNames);
    }
}