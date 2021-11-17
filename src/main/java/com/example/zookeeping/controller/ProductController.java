package com.example.zookeeping.controller;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping("/all")
    public Map<String, Integer> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/add")
    public Product addProduct(@PathVariable("id") Integer productId, @RequestParam Integer addValue) {
        return productService.addAmountOfProduct(productId, addValue);
    }

    @DeleteMapping
    public void deleteAll() {
        productService.deleteAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
