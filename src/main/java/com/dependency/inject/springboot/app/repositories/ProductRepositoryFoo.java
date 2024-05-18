package com.dependency.inject.springboot.app.repositories;

import com.dependency.inject.springboot.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{
    @Override
    public List<Product> findAll(){
        return Collections.singletonList(new Product(1L,"ASUS",600L)); //solo para una lista
    }

    public Product findById(Long id){
        return new Product(id, "Asus", 600L);
    }
}
