package com.example.finby.controller;

import com.example.finby.model.Product;
import com.example.finby.service.ProductServiceImpl;
import com.example.finby.service.SpecialFeatureServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// к сожалению , я не смог настроить соединение с бд
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServiceImpl productService;
    private SpecialFeatureServiceImpl specialFeatureService;

    @Autowired
    public ProductController(ProductServiceImpl productService, SpecialFeatureServiceImpl specialFeatureService) {
        this.productService = productService;
        this.specialFeatureService = specialFeatureService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        for (Product product : products) {
            product.setFeatures(specialFeatureService.getAllByProductId(product.getId()));
        }
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

     
}
