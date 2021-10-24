package com.example.zookeeping.service;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProduct(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Продукт не найден"));
    }

    public Map<String, Integer> getAllProducts() {
        return productRepository.findAll().stream()
                .collect(toMap(Product::getName, Product::getAmount));
    }

    public Product addAmountOfProduct(Integer productId, Integer addValue) {
        Product product = getProduct(productId);
        Integer oldValue = product.getAmount();
        product.setAmount(Integer.sum(oldValue, addValue));
        productRepository.save(product);
        return product;
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
