package com.example.zookeeping.service;

import com.example.zookeeping.stubs.AnimalRepositoryStub;
import org.junit.jupiter.api.BeforeEach;

public class AnimalServiceTest {

    private final AnimalRepositoryStub animalRepositoryStub = new AnimalRepositoryStub();
    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        animalService = new AnimalService(animalRepositoryStub);
    }
}
