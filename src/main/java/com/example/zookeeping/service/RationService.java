package com.example.zookeeping.service;

import com.example.zookeeping.model.Ration;
import com.example.zookeeping.repository.ProductRepository;
import com.example.zookeeping.repository.RationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@AllArgsConstructor
public class RationService {

    private final RationRepository rationRepository;
    private final ProductRepository productRepository;

    public void addRation(Integer animalId, Integer productId, Integer dailyRate) {
        List<Integer> productList = rationRepository.findAllByAnimalId(animalId).stream()
                .map(Ration::getProduct)
                .collect(Collectors.toList());
        if (productList.contains(productId)) {
            throw new IllegalArgumentException("Данный продукт уже включён в рацион");
        }

        rationRepository.save(Ration.of(animalId, productId, dailyRate));
    }

    public Map<String, Integer> getRationOfAnimal(Integer animalId) {
        List<Ration> rationList = rationRepository.findAllByAnimalId(animalId);
        if (rationList.isEmpty()) {
            return new HashMap<>();
        }

        return rationList.stream()
                .collect(toMap(ration ->
                                productRepository.findById(ration.getProduct()).get().getName(),
                        Ration::getDailyRate
                ));
    }

}
