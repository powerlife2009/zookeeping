package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal(Integer animalId) {
        return animalRepository.getById(animalId);
    }

    public Stream<Animal> getAllAnimals() {
        return animalRepository.findAll().stream();
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Integer animalId) {
        animalRepository.deleteById(animalId);
    }

    public void deleteAllAnimals() {
        animalRepository.deleteAll();
    }

    public void deleteSomeAnimals(List<Integer> animalIds) {
        List<Animal> animals = animalRepository.findAllById(animalIds);
        if (animals.isEmpty()) {
            throw new IllegalArgumentException("Животные не найдены");
        }
        animalRepository.deleteAll(animals);
    }

    public void updateAnimal(Integer animalId, Integer newDailyRate, Integer productId) {

    }
}
