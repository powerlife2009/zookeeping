package com.example.zookeeping.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private boolean predator;

    public static Animal of(Integer animalId, String animalName) {
        Animal animal = new Animal();
        animal.setId(animalId);
        animal.setName(animalName);
        return animal;
    }
}
