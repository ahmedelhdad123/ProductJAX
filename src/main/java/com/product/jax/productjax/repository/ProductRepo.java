package com.product.jax.productjax.repository;

import com.product.jax.productjax.entity.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> findAll();

    Product findById(int id);

    void add(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product findByName(String name);
}
