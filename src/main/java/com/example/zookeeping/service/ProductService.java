package com.example.zookeeping.service;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Integer productId) {
        return productRepository.getById(productId);
    }

    public Stream<Product> getAllProducts() {
        return productRepository.findAll().stream();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public void deleteSomeProducts(List<Integer> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        productRepository.deleteAll(products);
    }

    public void updateProduct(Integer productId, Integer newAmount) {
        Product updateProduct = productRepository.getById(productId);
        updateProduct.setAmount(newAmount);
        productRepository.save(updateProduct);
    }
}
