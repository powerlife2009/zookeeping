package com.example.zookeeping.controller;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/all")
    public List<Animal> getAll() {
        return animalService.getAllAnimals().collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimal(@PathVariable("id") Integer id) {
        animalService.deleteAnimal(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        animalService.deleteAllAnimals();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSome(@RequestBody List<Integer> animalIds) {
        animalService.deleteSomeAnimals(animalIds);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAnimal(@PathVariable("id") Integer animalId,
                             @RequestBody Integer newDailyRate,
                             @RequestBody Integer productId) {
        animalService.updateAnimal(animalId, newDailyRate, productId);
    }
}
