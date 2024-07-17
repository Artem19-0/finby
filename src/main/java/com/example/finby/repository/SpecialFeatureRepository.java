package com.example.finby.repository;

import com.example.finby.model.SpecialFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialFeatureRepository extends JpaRepository<SpecialFeature, Integer> {

    @Query("select s from SpecialFeature s where s.products = :id")
    List<SpecialFeature> getAllByProductId(int id);
}
