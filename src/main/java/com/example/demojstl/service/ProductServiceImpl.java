package com.example.demojstl.service;

import com.example.demojstl.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IService {
    List<Product> listProduct;

    public ProductServiceImpl() {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Sanpham1", 100, "tot"));
        listProduct.add(new Product(2, "Sanpham2", 100, "tot"));
        listProduct.add(new Product(3, "Sanpham3", 100, "tot"));
        listProduct.add(new Product(4, "Sanpham4", 100, "tot"));
        listProduct.add(new Product(5, "Sanpham5", 100, "tot"));
    }

    @Override
    public List<Product> finAll() {
        return listProduct;
    }

    @Override
    public void add(Product p) {
        listProduct.add(p);
    }

    @Override
    public void edit(int id, Product newProduct) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                listProduct.set(i, newProduct);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product p: listProduct
             ) {
            if (p.getId()==id) {
                listProduct.remove(p);
                break;
            }
        }
    }

    public Product findByID(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                return listProduct.get(i);
            }
        }
        return null;
    }
}
