package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimal(Integer animalId) {
        return animalRepository.findById(animalId);
    }

    public Stream<Animal> getAllAnimals() {
        return animalRepository.findAll().stream();
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Integer animalId) {
        Optional<Animal> animal = getAnimal(animalId);
        animal.ifPresent(animalRepository::delete);
    }

    public void deleteAllAnimals() {
        animalRepository.deleteAll();
    }

    public void deleteSomeAnimals(Integer... animalIds) {
        List<Animal> animals = animalRepository.findAllById(Arrays.asList(animalIds));
        if (animals.isEmpty()) {
            throw new IllegalArgumentException("Животные не найдены");
        }
        animalRepository.deleteAll(animals);
    }
}
