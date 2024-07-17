package com.example.finby.service;

import com.example.finby.model.Product;
import com.example.finby.model.SpecialFeature;

import java.util.List;

public interface SpecialFeatureService {

    List<SpecialFeature> getAllByProductId(int id);

    List<SpecialFeature> getAll();
    SpecialFeature getById(int id);
    void create(SpecialFeature specialFeature);
    void update(SpecialFeature specialFeature);
    void delete(int id);
}
