package com.example.zookeeping.service;

import com.example.zookeeping.model.Ration;
import com.example.zookeeping.repository.AnimalRepository;
import com.example.zookeeping.repository.ProductRepository;
import com.example.zookeeping.repository.RationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@AllArgsConstructor
public class RationService {

    private final RationRepository rationRepository;
    private final ProductRepository productRepository;
    private final AnimalRepository animalRepository;

    public void addRation(Integer animalId, Integer productId, Integer dailyRate) {
        List<Integer> productList = rationRepository.findAllByAnimalId(animalId).stream()
                .map(Ration::getProduct)
                .collect(Collectors.toList());
        Assert.isTrue(!productList.contains(productId), "Данный продукт уже включён в рацион");

        rationRepository.save(Ration.of(animalId, productId, dailyRate));
    }

    public Map<String, Integer> getRationOfAnimal(Integer animalId) {
        List<Ration> rationList = rationRepository.findAllByAnimalId(animalId);
        Assert.isTrue(!rationList.isEmpty(), "Рацион не назначен животному");

        return rationList.stream()
                .collect(toMap(productName(), Ration::getDailyRate));
    }

    public Map<String, Map<String, Integer>> getFullDetailsAnimals() {
        return rationRepository.findAll().stream()
                .collect(Collectors.groupingBy(animalName(),
                        Collectors.toMap(productName(), Ration::getDailyRate)));
    }

    private Function<Ration, String> productName() {
        return ration -> productRepository.findById(ration.getProduct()).get().getName();
    }

    private Function<Ration, String> animalName() {
        return ration -> animalRepository.findById(ration.getAnimal()).get().getName();
    }
}
