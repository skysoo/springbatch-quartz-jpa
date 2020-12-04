package com.study.batch.dao.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyJpaRepository<T> {
    T findById(long id);
    List<T> findByAll();
    List<T> findByAllWithSort(Sort sort);
    void save(T t);
    void saveAndFlush(T t);
    void deleteById(long id);
}
