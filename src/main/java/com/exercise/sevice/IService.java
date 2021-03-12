package com.exercise.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void deleteById(Long id);

    Page<T> findAllPage(Pageable pageable);
}
