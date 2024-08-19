package org.practice.dsa.java8.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class ProductManagementSystem {

    public List<Product> filterProductsByCategory(List<Product> product, String category) {
        return product.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
