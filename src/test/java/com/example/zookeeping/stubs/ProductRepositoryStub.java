package com.example.zookeeping.stubs;

import com.example.zookeeping.model.Product;
import com.example.zookeeping.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryStub implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findAll(Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public List<Product> findAllById(Iterable<Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteById(Integer integer) {
        products.removeIf(product -> product.getId().equals(integer));
    }

    @Override
    public void delete(Product entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll() {
        products.clear();
    }

    @Override
    public <S extends Product> S save(S entity) {
        products.add(entity);
        return entity;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        products.addAll((Collection<? extends Product>) entities);
        return (List<S>) products;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return products.stream()
                .filter(product -> product.getId().equals(integer))
                .findFirst();
    }

    @Override
    public boolean existsById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Product getOne(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Product getById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    public void clear() {
        products.clear();
    }
}
