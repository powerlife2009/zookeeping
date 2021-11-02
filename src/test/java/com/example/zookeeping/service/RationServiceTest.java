package com.example.zookeeping.service;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.model.Product;
import com.example.zookeeping.model.Ration;
import com.example.zookeeping.stubs.AnimalRepositoryStub;
import com.example.zookeeping.stubs.ProductRepositoryStub;
import com.example.zookeeping.stubs.RationRepositoryStub;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

public class RationServiceTest {

    private final RationRepositoryStub rationRepositoryStub = new RationRepositoryStub();
    private final ProductRepositoryStub productRepositoryStub = new ProductRepositoryStub();
    private final AnimalRepositoryStub animalRepositoryStub = new AnimalRepositoryStub();
    private final RationService rationService =
            new RationService(rationRepositoryStub, productRepositoryStub, animalRepositoryStub);


    @AfterEach
    void tearDown() {
        rationRepositoryStub.clear();
        productRepositoryStub.clear();
        animalRepositoryStub.clear();
    }

    @Test
    void should_return_ration_as_product_and_dailyRate_for_selected_animal() {
        Product banana = createProduct("banana");
        Animal monkey = createAnimal("Monkey");
        Ration ration = setRation(monkey, banana, 100);

        assertThat(rationService.getRationOfAnimal(monkey.getId()))
                .containsKey(banana.getName())
                .containsValue(ration.getDailyRate());
    }

    @Test
    void should_return_error_if_ration_not_assigned_for_selected_animal() {
        Product banana = createProduct( "banana");
        Animal monkey = createAnimal("Monkey");

        assertThatThrownBy(() -> rationService.getRationOfAnimal(monkey.getId()))
                .hasMessage("Рацион не назначен животному");
    }

    @Test
    void should_add_product_to_ration_if_product_is_not_already_included() {
        Product banana = createProduct("banana");
        Animal monkey = createAnimal("Monkey");

        rationService.addRation(monkey.getId(), banana.getId(), 50);

        assertThat(rationRepositoryStub.findAllByAnimalId(monkey.getId()))
                .extracting(Ration::getProduct, Ration::getDailyRate)
                .containsOnly(tuple(banana.getId(), 50));
    }

    @Test
    void should_return_error_if_product_is_already_included() {
        Product banana = createProduct("banana");
        Animal monkey = createAnimal("Monkey");
        setRation(monkey, banana, 150);

        assertThatThrownBy(() -> rationService.addRation(monkey.getId(), banana.getId(), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Данный продукт уже включён в рацион");
    }

    private Animal createAnimal(String animalName) {
        Animal animal = Animal.of(new Random().nextInt(10), animalName);
        return animalRepositoryStub.save(animal);
    }

    private Product createProduct(String productName) {
        Product product = Product.of(new Random().nextInt(10), productName);
        return productRepositoryStub.save(product);
    }

    private Ration setRation(Animal animal, Product product, Integer dailyRate) {
        Ration ration = Ration.of(animal.getId(), product.getId(), dailyRate);
        return rationRepositoryStub.save(ration);
    }
}
