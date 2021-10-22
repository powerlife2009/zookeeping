package com.example.zookeeping.repository;

import com.example.zookeeping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Override
    void deleteById(Integer productId);
}