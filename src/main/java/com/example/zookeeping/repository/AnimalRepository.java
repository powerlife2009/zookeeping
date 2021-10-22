package com.example.zookeeping.repository;

import com.example.zookeeping.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Override
    void deleteById(Integer animalId);
}
