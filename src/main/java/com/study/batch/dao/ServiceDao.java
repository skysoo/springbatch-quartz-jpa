package com.study.batch.dao;

import java.util.List;
import java.util.Optional;

public interface ServiceDao<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void deleteById(long id);
}
