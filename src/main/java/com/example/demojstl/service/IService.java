package com.example.demojstl.service;

import com.example.demojstl.model.Product;

import java.util.List;

public interface IService {
    List<Product> finAll();
    void add(Product p);
    void edit(int id, Product newProduct);
    void delete(int id);

}
