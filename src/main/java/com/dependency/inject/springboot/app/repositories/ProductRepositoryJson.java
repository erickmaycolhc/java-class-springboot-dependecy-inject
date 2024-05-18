package com.dependency.inject.springboot.app.repositories;

import com.dependency.inject.springboot.app.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() throws IOException {
        Resource resource= new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        }catch(StreamReadException e){
            e.printStackTrace();
        }catch(DatabindException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll(){
        return list;
    }
    @Override
    public Product findById(Long id){
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
