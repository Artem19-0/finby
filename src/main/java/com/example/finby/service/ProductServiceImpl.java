package com.example.finby.service;

import com.example.finby.model.Product;
import com.example.finby.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
        log.info("Initialization");
    }



    @Override
    public Optional<Product> findByName(String name) {
        if(!name.isEmpty()){
            log.info("Method 'findByName' passed check ");
            return Optional.of(repository.getByName(name));
        }else {
            log.warn("Method 'findByName' didn't pass check ");
            return Optional.empty();

        }
    }

    @Override
    public Product getProductMaxRating() {
        Product product = repository.getProductMaxRating();
        if(product != null){
            log.info("Method 'getProductMaxRating' passed check ");
            return product;
        } else {
            log.warn("Method 'getProductMaxRating' didn't pass check ");
            return null;
        }
    }

    @Override
    public Product getProductMaxPrice() {
        Product product = repository.getProductMaxPrice();
        if(product != null){
            log.info("Method 'getProductMaxPrice' passed check ");
            return product;
        } else {
            log.warn("Method 'getProductMaxPrice' didn't pass check ");
            return null;
        }
    }

    @Override
    public Product getProductMinPrice() {
        Product product = repository.getProductMinPrice();
        if(product != null){
            log.info("Method 'getProductMinPrice' passed check ");
            return product;
        } else {
            log.warn("Method 'getProductMinPrice' didn't pass check ");
            return null;
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = repository.findAll();
        return products.isEmpty() ? Collections.emptyList() : products;    }

    @Override
    public Optional<Product> getById(int id) {
        if(repository.findById(id).isPresent()) {
            log.info("Method 'getById' passed check ");
            return repository.findById(id);
        } else {
            log.warn("Method 'getById' didn't pass check ");
            return Optional.empty();
        }
    }

    @Override
    public void create(Product product) {
        try {
            repository.save(product);
            log.info("Method 'create' was done ");
        }catch (NullPointerException | IllegalArgumentException e){
            log.error("Method 'create' caught error");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            Optional<Product> product1 = repository.findById(product.getId());
            if (product1.isPresent()){
                log.info("Method 'update' passed check ");
                product1 = Optional.of(product);
               repository.save(product1.get());
            }
            log.info("Method 'update' was done ");
        }catch (NullPointerException | IllegalArgumentException e){
            log.error("Method 'update' caught error");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Optional<Product> product1 = repository.findById(id);
            product1.ifPresent(product -> repository.delete(product));
            log.info("Method 'delete' was done ");
        }catch (NullPointerException | IllegalArgumentException e){
            log.error("Method 'delete' caught error");
            e.printStackTrace();
        }
    }


}
