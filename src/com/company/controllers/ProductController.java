package com.company.controllers;

import com.company.entities.Product;
import com.company.repositories.interfaces.IProductsRepository;

import java.util.List;

public class ProductController {
        private final IProductsRepository pro;
        public ProductController(IProductsRepository pro){
            this.pro = pro;
        }
        public String createProduct(String name, String category, double price){
            Product product = new Product(name, category, price);
             boolean created = pro.createProduct(product);
            System.out.println(created ? "User was created!" : "User creation was failed!");
            return name;
        }
        public String getProduct(int id){
            Product product = pro.getProduct(id);
            return(product == null ? "User was not found!" : product.toString());
        }

        public String getAllProducts(){
            List<Product> product = pro.getAllProducts();
            return product.toString();
        }
    }
