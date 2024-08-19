package org.practice.dsa.java8.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagementSystem {

    public List<Product> filterProductsByCategory(List<Product> product, String category) {
        return product.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Product> sortProductByPrice(List<Product> products) {
        return products.stream()
                // Before enhance comparator code: (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();
    }
}
