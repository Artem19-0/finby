package com.example.finby.repository;

import com.example.finby.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product getByName(String name);
    @Query("select p from Product p where p.rating = (select max(p.rating) from Product p)")
    Product getProductMaxRating();

    @Query("select p from Product p where p.price = (select max(p.price) from Product p)")
    Product getProductMaxPrice();

    @Query("select p from Product p where p.price = (select min (p.price) from Product p)")
    Product getProductMinPrice();
}
