package com.example.zookeeping.controller;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.service.AnimalService;
import com.example.zookeeping.service.RationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;
    private final RationService rationService;

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/all")
    public List<Animal> getAll() {
        return animalService.getAllAnimals().collect(Collectors.toList());
    }

    @PutMapping("/{id}/ration/add")
    public void addRationForAnimal(@PathVariable("id") Integer animalId,
                                   @RequestParam Integer productId,
                                   @RequestParam Integer dailyRate) {
        rationService.addRation(animalId, productId, dailyRate);
    }
}
