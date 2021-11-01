package com.example.zookeeping.service;

import com.example.zookeeping.stubs.AnimalRepositoryStub;
import com.example.zookeeping.stubs.ProductRepositoryStub;
import com.example.zookeeping.stubs.RationRepositoryStub;
import org.junit.jupiter.api.BeforeEach;

public class RationServiceTest {

    private final RationRepositoryStub rationRepositoryStub = new RationRepositoryStub();
    private final ProductRepositoryStub productRepositoryStub = new ProductRepositoryStub();
    private final AnimalRepositoryStub animalRepositoryStub = new AnimalRepositoryStub();
    private RationService rationService;

    @BeforeEach
    void setUp() {
        rationService = new RationService(rationRepositoryStub, productRepositoryStub, animalRepositoryStub);
    }
}
