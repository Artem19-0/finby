package com.example.finby.service;

import com.example.finby.model.Product;
import com.example.finby.model.SpecialFeature;
import com.example.finby.repository.SpecialFeatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SpecialFeatureServiceImpl implements SpecialFeatureService{

    private SpecialFeatureRepository repository;

    @Autowired
    public SpecialFeatureServiceImpl(SpecialFeatureRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<SpecialFeature> getAllByProductId(int id) throws NullPointerException {
        List<SpecialFeature> specialFeature = repository.getAllByProductId(id);
        return specialFeature.isEmpty() ? Collections.emptyList() : specialFeature;
    }

    @Override
    public List<SpecialFeature> getAll() {
        List<SpecialFeature> specialFeatures = repository.findAll();
        return specialFeatures.isEmpty() ? Collections.emptyList() : specialFeatures;
    }

    @Override
    public SpecialFeature getById(int id) {
        Optional<SpecialFeature> specialFeature = repository.findById(id);
        if(specialFeature.isPresent()) {
            log.info("Method 'getById' passed check ");
            return specialFeature.get();
        } else {
            log.warn("Method 'getById' didn't pass check ");
            return null;
        }
    }

    @Override
    public void create(SpecialFeature specialFeature) {
        try {
            repository.save(specialFeature);
            log.info("Method 'create' was done ");
        }catch (NullPointerException | IllegalArgumentException e){
            log.error("Method 'create' caught error");
            e.printStackTrace();
        }
    }

    @Override
    public void update(SpecialFeature specialFeature) {
        try {
            Optional<SpecialFeature> specialFeature1 = repository.findById(specialFeature.getId());
            if (specialFeature1.isPresent()){
                log.info("Method 'update' passed check ");
                specialFeature1 = Optional.of(specialFeature);
                repository.save(specialFeature1.get());
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
            Optional<SpecialFeature> specialFeature = repository.findById(id);
            specialFeature.ifPresent(specialFeature1 -> repository.delete(specialFeature1));
            log.info("Method 'delete' was done ");
        }catch (NullPointerException | IllegalArgumentException e){
            log.error("Method 'delete' caught error");
            e.printStackTrace();
        }
    }
}
