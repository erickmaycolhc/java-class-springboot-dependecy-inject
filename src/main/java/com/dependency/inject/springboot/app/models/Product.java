package com.dependency.inject.springboot.app.models;

import java.util.Objects;

public class Product implements Cloneable{

    //atributos
    private Long   id;
    private String name;
    private Long   price;

    public Product(){} //contructor vacio
    public Product(Long id, String name, Long price){  //constructor
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Métodos
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getPrice(){
        return price;
    }

    public void setPrice(Long price){
        this.price= price;
    }

    public Object clone(){
        try{
            return  super.clone();
        }catch (CloneNotSupportedException e){
            return new Product(id,name,price);
        }
    }

}


//En resumen, en este caso se inicia con el constructor vacío para permitir la creación de instancias de Product
// sin necesidad de proporcionar valores iniciales para los atributos. Esto proporciona flexibilidad en el uso de
// la clase, ya que se pueden crear instancias con o sin valores específicos, dep endiendo de los requisitos del
// programa.




