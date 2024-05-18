package com.dependency.inject.springboot.app.controllers;

import com.dependency.inject.springboot.app.models.Product;
import com.dependency.inject.springboot.app.services.ProductService;
import com.dependency.inject.springboot.app.services.ProductServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {
    @Autowired
    private ProductService service; //instanciamos

    @GetMapping
    public List<Product> List(){
        return service.findAll();

    };

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){  //cuando lleva parametros en el service siempre lleva un @PathVariable
        return service.findById(id);
    }


}
