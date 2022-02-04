package com.company;

import com.company.controllers.ProductController;
import com.company.controllers.UserController;

import java.util.Scanner;

public class MyApplication {
    private final ProductController controller2;
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller, ProductController controller2) {
        this.controller2 = controller2;
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("4. Create product");
            System.out.println("5. Get all products");
            System.out.println("6. Get product by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllUsersMenu();
                } else if (option == 2) {
                    getUserByIdMenu();
                } else if (option == 3) {
                    createUserMenu();
                } else if(option == 4) {
                    createProductMenu();
                } else if (option == 6) {
                    getProductByIdMenu();
                } else if (option == 5) {
                    getAllProductsMenu();
                } else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();

        String response = controller.createUser(name, surname, gender);
        System.out.println(response);
    }
    public void getAllProductsMenu() {
        String response = controller2.getAllProducts();
        System.out.println(response);
    }

    public void getProductByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response2 = controller2.getProduct(id);
        System.out.println(response2);
    }

    public void createProductMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter category");
        String category = scanner.next();
        System.out.println("Please enter gender price");
        double price = scanner.nextDouble();

        String response2 = controller2.createProduct(name, category, price);
        System.out.println(response2);
    }
}