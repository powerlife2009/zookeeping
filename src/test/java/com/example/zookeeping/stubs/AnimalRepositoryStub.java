package com.example.zookeeping.stubs;

import com.example.zookeeping.model.Animal;
import com.example.zookeeping.repository.AnimalRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AnimalRepositoryStub implements AnimalRepository {

    private final List<Animal> animals = new ArrayList<>();

    @Override
    public List<Animal> findAll() {
        return animals;
    }

    @Override
    public List<Animal> findAll(Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Page<Animal> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public List<Animal> findAllById(Iterable<Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteById(Integer integer) {
        animals.removeIf(animal -> animal.getId().equals(integer));
    }

    @Override
    public void delete(Animal entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Animal> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll() {
        animals.clear();
    }

    @Override
    public <S extends Animal> S save(S entity) {
        animals.add(entity);
        return entity;
    }

    @Override
    public <S extends Animal> List<S> saveAll(Iterable<S> entities) {
        animals.addAll((Collection<Animal>) entities);
        return (List<S>) animals;
    }

    @Override
    public Optional<Animal> findById(Integer integer) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(integer))
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
    public <S extends Animal> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllInBatch(Iterable<Animal> entities) {
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
    public Animal getOne(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Animal getById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> long count(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Animal> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    public void clear() {
        animals.clear();
    }
}
