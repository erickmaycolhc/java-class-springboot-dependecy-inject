package com.dependency.inject.springboot.app.repositories;

import com.dependency.inject.springboot.app.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);
}
