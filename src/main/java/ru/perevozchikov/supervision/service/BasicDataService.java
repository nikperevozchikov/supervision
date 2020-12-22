package ru.perevozchikov.supervision.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@AllArgsConstructor
public abstract class BasicDataService<T, ID> {
    protected final JpaRepository<T, ID> repository;

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    public T save(T object) {
        return repository.save(object);
    }

    public List<T> saveList(List<T> list) {
        return (List<T>) repository.saveAll(list);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
