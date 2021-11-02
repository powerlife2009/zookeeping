package com.example.zookeeping.service;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.stubs.ProductRepositoryStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductServiceTest {

    private final ProductRepositoryStub productRepositoryStub = new ProductRepositoryStub();
    private final Integer MEAT_ID = 1;
    private final Integer APPLE_ID = 2;
    private final ProductService service = new ProductService(productRepositoryStub);

    @AfterEach
    void tearDown() {
        productRepositoryStub.clear();
    }

    @Test
    void should_return_product_by_id_if_product_is_present() {
        productRepositoryStub.save(createProduct(APPLE_ID));

        assertThat(service.getProduct(APPLE_ID))
                .extracting(Product::getId)
                .isEqualTo(APPLE_ID);
    }

    @Test
    void should_return_error_if_product_is_not_present() {
        assertThatThrownBy(() -> service.getProduct(MEAT_ID))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Продукт не найден");
    }

    @Test
    void should_save_new_product() {
        service.createProduct(createProduct(APPLE_ID));

        assertThat(productRepositoryStub.findById(APPLE_ID))
                .isPresent();
    }

    @Test
    void should_return_all_products() {
        productRepositoryStub.saveAll(
                List.of(createProduct("APPLE", 100), createProduct("MEAT", 200)));

        assertThat(service.getAllProducts()).hasSize(2)
                .as("Содержит яблоки в количестве")
                .containsKey("APPLE").containsValue(100)
                .as("Содержит мясо в количестве")
                .containsKey("MEAT").containsValue(200);
    }

    @Test
    void should_delete_product() {
        productRepositoryStub.save(createProduct(APPLE_ID));

        service.deleteProduct(APPLE_ID);

        assertThat(productRepositoryStub.findById(APPLE_ID)).isNotPresent();
    }

    @Test
    void should_delete_all_products() {
        productRepositoryStub.saveAll(List.of(createProduct(APPLE_ID), createProduct(MEAT_ID)));

        service.deleteAllProducts();

        assertThat(productRepositoryStub.findAll()).isEmpty();
    }

    @Test
    void should_add_amount_of_selected_product() {
        Product apple = createProduct(APPLE_ID);
        apple.setAmount(100);
        productRepositoryStub.save(apple);

        service.addAmountOfProduct(APPLE_ID, 100);

        assertThat(productRepositoryStub.findById(APPLE_ID)).get()
                .extracting(Product::getAmount)
                .as("Количество продукта увеличилось")
                .isEqualTo(200);
    }

    private Product createProduct(Integer productId) {
        Product product = new Product();
        product.setId(productId);
        return product;
    }

    private Product createProduct(String productName, Integer amount) {
        Product product = new Product();
        product.setName(productName);
        product.setAmount(amount);
        return product;
    }
}
