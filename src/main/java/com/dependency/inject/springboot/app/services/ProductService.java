package com.dependency.inject.springboot.app.services;

import com.dependency.inject.springboot.app.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
