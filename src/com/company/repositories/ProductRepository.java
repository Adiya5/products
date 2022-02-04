package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Product;
import com.company.repositories.interfaces.IProductsRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements IProductsRepository {
    private final IDB db2;

    public ProductRepository(IDB db2) {
        this.db2 = db2;
    }

    @Override
    public boolean createProduct(Product product) {
        Connection con = null;
        try {
            con = db2.getConnection();
            String sql = "INSERT INTO products(name,category,price) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getName());
            st.setString(2, product.getCategory());
            st.setDouble(3, product.getPrice());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProduct(int id) {
        Connection con = null;
        try {
            con = db2.getConnection();
            String sql = "SELECT id,name,category,price FROM products WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"));

                return product;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Connection con = null;
        try {
            con = db2.getConnection();
            String sql = "SELECT id,name,category,price FROM products";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Product> products = new LinkedList<>();
            while (rs.next()) {
                Product product;
                product = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble ("price"));

                products.add(product);
            }

            return products;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
