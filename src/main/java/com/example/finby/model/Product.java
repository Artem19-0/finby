package com.example.finby.model;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String model;

    @Column(name = "available_quantity")
    private int availableQuantity;

    @Column
    private double weight;

    @Column
    private double rating;

    @Column
    private String category;

    @Column
    private String description;

    @Column
    private String color;

    @Column
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private String photo;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "products_features", joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = {@JoinColumn(name = "feature_id") })
    private Set<SpecialFeature> features;

}
