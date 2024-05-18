package com.dependency.inject.springboot.app.services;

import com.dependency.inject.springboot.app.models.Product;
import com.dependency.inject.springboot.app.repositories.ProductRepository;
import com.dependency.inject.springboot.app.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServicelmpl implements  ProductService {    // "Service "lógica de negocio"
    //@Autowired
    //@Qualifier("productList")
    @Value("${config.price.tax}")
    private Double tax;
    private ProductRepository repository;   //instanciar

    public ProductServicelmpl(@Qualifier("productJson") ProductRepository repository){
        this.repository = repository;
    }
    @Override       //SOBREESCRITURA O UNA IMPLEMENTACIÓN DEL MÉTODO DE INTERFACE PONEMOS @Override PARA SABER QUE ES UNA SOBREESCRITURA
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            System.out.println(tax);
            Double priceTax = (p.getPrice() * tax);                                           //poniendo la lógica de impuesto
            //Product newProduct = new Product(p.getId(),p.getName() ,priceTex.longValue());
            Product newTex = (Product)p.clone();                                              //para que no sea inmutable con el clone
            newTex.setPrice(priceTax.longValue());
            return newTex;
            //p.setPrice(priceTax.longValue());
        }).collect(Collectors.toList());  //convierte a una lista
    };

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}


