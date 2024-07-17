package com.example.finby.service;

import com.example.finby.model.SpecialFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SpecialFeatureServiceImpl implements SpecialFeatureService{
    @Override
    public List<SpecialFeature> getAllByProductId(int id) {
        return null;
    }

    @Override
    public List<SpecialFeature> getAll() {
        return null;
    }

    @Override
    public SpecialFeature getById(int id) {
        return null;
    }

    @Override
    public void create(SpecialFeature specialFeature) {

    }

    @Override
    public void update(SpecialFeature specialFeature) {

    }

    @Override
    public void delete(int id) {

    }
}
