package com.example.zookeeping.stubs;

import com.example.zookeeping.model.Ration;
import com.example.zookeeping.repository.RationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RationRepositoryStub implements RationRepository {

    private final List<Ration> rations = new ArrayList<>();

    @Override
    public List<Ration> findAllByAnimalId(Integer animalId) {
        return rations.stream()
                .filter(ration -> ration.getAnimal().equals(animalId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ration> findAll() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public List<Ration> findAll(Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Page<Ration> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public List<Ration> findAllById(Iterable<Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void delete(Ration entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Ration> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> S save(S entity) {
        rations.add(entity);
        return entity;
    }

    @Override
    public <S extends Ration> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Optional<Ration> findById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
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
    public <S extends Ration> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void deleteAllInBatch(Iterable<Ration> entities) {
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
    public Ration getOne(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Ration getById(Integer integer) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> long count(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public <S extends Ration> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    public void clear() {
        rations.clear();
    }
}
