package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public Animal getAnimal(Integer animalId) {
        return animalRepository.findById(animalId).orElseThrow(() -> new IllegalArgumentException("Животное не найдено"));
    }

    public Stream<Animal> getAllAnimals() {
        return animalRepository.findAll().stream();
    }
}
