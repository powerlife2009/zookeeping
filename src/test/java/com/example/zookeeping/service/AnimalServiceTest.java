package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.stubs.AnimalRepositoryStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalServiceTest {

    private final AnimalRepositoryStub animalRepositoryStub = new AnimalRepositoryStub();
    private final Integer DOG_ID = 1;
    private final Integer CAT_ID = 2;
    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        animalService = new AnimalService(animalRepositoryStub);
    }

    @AfterEach
    void tearDown() {
        animalRepositoryStub.clear();
    }

    @Test
    void should_return_animal_by_id_if_animal_is_present() {
        animalRepositoryStub.save(createAnimal(DOG_ID));

        assertThat(animalService.getAnimal(DOG_ID))
                .extracting(Animal::getId)
                .isEqualTo(DOG_ID);
    }

    @Test
    void should_return_error_if_animal_is_not_present() {
        Assertions.assertThatThrownBy(() -> animalService.getAnimal(CAT_ID))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Животное не найдено");
    }

    @Test
    void should_save_new_animal() {
        animalService.createAnimal(createAnimal(CAT_ID));

        assertThat(animalRepositoryStub.findById(CAT_ID))
                .isPresent();
    }

    @Test
    void should_return_all_animals() {
        animalRepositoryStub.saveAll(List.of(createAnimal(CAT_ID), createAnimal(DOG_ID)));

        assertThat(animalService.getAllAnimals()).hasSize(2)
                .extracting(Animal::getId)
                .containsOnly(CAT_ID, DOG_ID);
    }

    @Test
    void should_delete_animal() {
        animalRepositoryStub.save(createAnimal(DOG_ID));

        animalService.deleteAnimal(DOG_ID);

        assertThat(animalRepositoryStub.findById(DOG_ID)).isNotPresent();
    }

    @Test
    void should_delete_all_animals() {
        animalRepositoryStub.saveAll(List.of(createAnimal(CAT_ID), createAnimal(DOG_ID)));

        animalService.deleteAllAnimals();

        assertThat(animalRepositoryStub.findAll()).isEmpty();
    }

    private Animal createAnimal(Integer animalId) {
        Animal animal = new Animal();
        animal.setId(animalId);
        return animal;
    }
}
