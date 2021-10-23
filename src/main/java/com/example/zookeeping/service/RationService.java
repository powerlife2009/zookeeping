package com.example.zookeeping.service;

import com.example.zookeeping.model.Ration;
import com.example.zookeeping.repository.RationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RationService {

    private final RationRepository rationRepository;

    @Autowired
    public RationService(RationRepository rationRepository) {
        this.rationRepository = rationRepository;
    }

    public void addRation(Integer animalId, Integer productId, Integer dailyRate) {
        List<Integer> productList = rationRepository.findAllByAnimalId(animalId).stream()
                .map(Ration::getProduct)
                .collect(Collectors.toList());
        if (productList.contains(productId)) {
            throw new IllegalArgumentException("Данный продукт уже включён в рацион");
        }

        rationRepository.save(Ration.of(animalId, productId, dailyRate));
    }
}
