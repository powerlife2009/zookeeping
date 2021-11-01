package com.example.zookeeping.service;

import com.example.zookeeping.stubs.ProductRepositoryStub;
import org.junit.jupiter.api.BeforeEach;

public class ProductServiceTest {

    private final ProductRepositoryStub productRepositoryStub = new ProductRepositoryStub();
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepositoryStub);
    }
}
