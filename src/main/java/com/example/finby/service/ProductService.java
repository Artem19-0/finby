package com.example.finby.service;

import com.example.finby.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findByName(String name);
    Product getProductMaxRating();
    Product getProductMaxPrice();
    Product getProductMinPrice();


    List<Product> getAll();
    Optional<Product> getById(int id);
    void create(Product product);
    void update(Product product);
    void delete(int id);

}
