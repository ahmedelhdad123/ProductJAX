package com.product.jax.productjax.repository;

import jakarta.inject.Singleton;
import com.product.jax.productjax.entity.Product;
import com.product.jax.productjax.exception.ProductException;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductRepoImpl implements ProductRepo {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        Product existingProduct = findById(id);
        if (existingProduct != null) {
            products.set(products.indexOf(existingProduct), product);
        } else {
            throw new ProductException("Product with id " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
        } else {
            throw new ProductException("Product with id " + id + " not found");
        }
    }

    @Override
    public Product findByName(String name) {
        return products.stream()
                .filter(product -> product.getProductName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ProductException("Product with name " + name + " not found"));
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
