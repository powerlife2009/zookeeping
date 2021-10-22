package com.example.zookeeping.controller;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAllProducts().collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        productService.deleteAllProducts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSome(@RequestBody List<Integer> productIds) {
        productService.deleteSomeProducts(productIds);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("id") Integer productId, @RequestBody Integer newAmount) {
        productService.updateProduct(productId, newAmount);
    }
}
