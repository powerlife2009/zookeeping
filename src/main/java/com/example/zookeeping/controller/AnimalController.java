package com.example.zookeeping.controller;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.service.AnimalService;
import com.example.zookeeping.service.RationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;
    private final RationService rationService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getAnimal(@PathVariable("id") Integer id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAll() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/all/details")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Map<String, Integer>> getFullInfo() {
        return rationService.getFullDetailsAnimals();
    }

    @GetMapping("/{id}/ration")
    public Map<String, Integer> getRationOfAnimal(@PathVariable("id") Integer animalId) {
        return rationService.getRationOfAnimal(animalId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/{id}/ration/add")
    @ResponseStatus(HttpStatus.OK)
    public void addRationForAnimal(@PathVariable("id") Integer animalId,
                                   @RequestParam Integer productId,
                                   @RequestParam Integer dailyRate) {
        rationService.addRation(animalId, productId, dailyRate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimal(@PathVariable("id") Integer animalId) {
        animalService.deleteAnimal(animalId);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllAnimal() {
        animalService.deleteAllAnimal();
    }
}
