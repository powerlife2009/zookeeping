package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public Animal getAnimal(Integer animalId) {
        return animalRepository.findById(animalId).orElseThrow(() -> new IllegalArgumentException("Животное не найдено"));
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.saveAndFlush(animal);
    }

    public void deleteAnimal(Integer animalId) {
        animalRepository.deleteById(animalId);
    }

    public void deleteAllAnimals() {
        animalRepository.deleteAll();
    }
}
