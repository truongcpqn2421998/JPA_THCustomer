package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface IService <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

    void update(Customer customer);
}
