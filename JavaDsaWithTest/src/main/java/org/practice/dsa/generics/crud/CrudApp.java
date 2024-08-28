package org.practice.dsa.generics.crud;

import org.practice.dsa.generics.crud.entity.Product;
import org.practice.dsa.generics.crud.entity.User;
import org.practice.dsa.generics.crud.entity.repo.Repository;

public class CrudApp {
    public static void main(String[] args) {

        Repository<User> userRepository = new Repository<>();

        userRepository.add(new User(10, "Vishwajeet"));
        userRepository.add(new User(11, "Ravi"));

        System.out.println("Get all users: "+userRepository.getAll());

        System.out.println("Get user by id:"+userRepository.getById(10));

        userRepository.update(11, new User(111,"Ravi kumar"));
        System.out.println("Update User by id: "+userRepository.getById(111));

        userRepository.delete(111);
        System.out.println("User list after delete operations: "+userRepository.getAll());

        Repository<Product> productRepository = new Repository<>();

        productRepository.add(new Product(101, "Mobile"));
        productRepository.add(new Product(102, "Laptop"));

        System.out.println("Get all Products: "+productRepository.getAll());

        System.out.println("Get product by id:"+productRepository.getById(10));

        productRepository.update(102, new Product(103,"Ravi kumar"));
        System.out.println("Update product by id: "+productRepository.getById(111));

        productRepository.delete(102);
        System.out.println("Product list after delete operations: "+productRepository.getAll());
    }
}
