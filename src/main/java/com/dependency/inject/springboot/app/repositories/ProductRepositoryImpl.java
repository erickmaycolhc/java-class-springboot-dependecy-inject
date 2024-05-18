package com.dependency.inject.springboot.app.repositories;

import com.dependency.inject.springboot.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

//@RequestScope   para mantener mantener los datos por tiempo
//@SessionScope   para mantener mantener los datos por tiempo de session
@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{
    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
                new Product(1L,"Computer", 2000L),
                new Product(2L, "Laptop", 1000L),
                new Product(3l, "Teclado", 250L)
        );
   }
   public List<Product> findAll(){
        return data;
   };
    public Product findById(Long id){   //traer el primer id por orden
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
