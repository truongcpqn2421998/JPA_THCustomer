package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface IRepository <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

    void update(Customer customer);
}
