package com.example.zookeeping.repository;

import com.example.zookeeping.model.Ration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RationRepository extends JpaRepository<Ration, Integer> {

    @Query("SELECT e FROM Ration e WHERE e.animal=:animalId")
    List<Ration> findAllByAnimalId(Integer animalId);
}
