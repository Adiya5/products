package com.company;

import com.company.controllers.ProductController;
import com.company.controllers.UserController;
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import com.company.entities.Product;
import com.company.entities.User;
import com.company.repositories.ProductRepository;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IProductsRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new DB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);

        IDB db2 = new DB();
        IProductsRepository pro = new ProductRepository(db2);
        ProductController controller2 = new ProductController(pro);
        MyApplication app = new MyApplication(controller, controller2);
        app.start();
    }
}
