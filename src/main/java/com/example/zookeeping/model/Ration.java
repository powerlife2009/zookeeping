package com.example.zookeeping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer animal;

    private Integer product;

    private Integer dailyRate;

    public static Ration of(Integer animalId, Integer productId, Integer dailyRate) {
        Ration ration = new Ration();
        ration.setAnimal(animalId);
        ration.setProduct(productId);
        ration.setDailyRate(dailyRate);
        return ration;
    }
}
