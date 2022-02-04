package com.company.repositories.interfaces;

import com.company.entities.Product;

import java.util.List;

public interface IProductsRepository {
        boolean createProduct(Product product);
        Product getProduct(int id);
        List<Product> getAllProducts();
}
