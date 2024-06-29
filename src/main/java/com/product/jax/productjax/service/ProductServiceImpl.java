package com.product.jax.productjax.service;

import com.product.jax.productjax.entity.Product;
import com.product.jax.productjax.exception.ProductException;
import com.product.jax.productjax.repository.ProductRepo;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public void update(int id, Product product) {
        Product existingProduct = productRepo.findById(id);
        if (existingProduct == null) {
            throw new ProductException("Product with id " + id + " not found");
        }
        productRepo.update(id, product);
    }

    @Override
    public void delete(int id) {
        Product existingProduct = productRepo.findById(id);
        if (existingProduct == null) {
            throw new ProductException("Product with id " + id + " not found");
        }
        productRepo.delete(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }
}
