package com.cipfpmislata.proyecto3evaluacion.domain.entity;

import java.math.BigDecimal;

public class Article {

    private String user_id;
    private int product_id;
    private int quantity;
    private BigDecimal price;
    private String product_name;

    public Article(String user_id, int product_id, int quantity, BigDecimal price, String product_name) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.product_name = product_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProduct_name() {
        return product_name;
    }

    @Override
    public String toString() {
        return "Article [user_id=" + user_id + ", product_id=" + product_id + ", quantity=" + quantity + ", price="
                + price + "]";
    }

}
