package com.cipfpmislata.proyecto3evaluacion.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cipfpmislata.proyecto3evaluacion.database.DBUtil;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Article;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;
import com.cipfpmislata.proyecto3evaluacion.persistence.CartRepository;

public class CartRepositoryImplJDBC implements CartRepository{

    @Override
    public boolean addArticle(Article article) {
        Connection connection = DBUtil.open();
        String sql = "INSERT INTO carts (user_id, product_id, quantity, price) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE quantity = quantity + ?";
        List<Object> params = List.of(article.getUser_id(), article.getProduct_id(), article.getQuantity(), article.getPrice(), article.getQuantity());
        boolean result = DBUtil.insert(connection, sql, params);
        DBUtil.close(connection);
        return result;
    }

    @Override
    public Cart getByUserId(String user_id) {
        try {
            List<Article> articles = new ArrayList<>();
            Connection connection = DBUtil.open();
            String sql = "SELECT carts.*, products.brand, products.name FROM carts INNER JOIN products ON carts.product_id = products.id WHERE carts.user_id = ?";
            List<Object> params = List.of(user_id);
            ResultSet resultSet = DBUtil.select(connection, sql, params);
            DBUtil.close(connection);
            while (resultSet.next()) {
                Article article = new Article(
                    resultSet.getString("carts.user_id"),
                    resultSet.getInt("carts.product_id"),
                    resultSet.getInt("carts.quantity"),
                    resultSet.getBigDecimal("carts.price"),
                    resultSet.getString("products.brand") + " - " + resultSet.getString("products.name")
                );
                articles.add(article);
            }
            Cart cart = new Cart(articles);
            return cart;
                
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean deleteArticle(int article_id, String user_id) {
        Connection connection = DBUtil.open();
        String sql = "DELETE FROM carts WHERE product_id = ? AND user_id = ?";
        List<Object> params = List.of(article_id, user_id);
        boolean result = DBUtil.delete(connection, sql, params);
        DBUtil.close(connection);
        return result;
    }
    
}
