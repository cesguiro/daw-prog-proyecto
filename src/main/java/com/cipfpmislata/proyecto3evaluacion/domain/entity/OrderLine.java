package com.cipfpmislata.proyecto3evaluacion.domain.entity;

import java.math.BigDecimal;

public class OrderLine {

    private int order_id;
    private int product_id;
    private String product_name;
    private int product_quantity;
    private BigDecimal product_price;

    public OrderLine(int order_id, int product_id, String product_name, int product_quantity,
            BigDecimal product_price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    @Override
    public String toString() {
        return "OrderLine [order_id=" + order_id + ", product_id=" + product_id + ", product_name=" + product_name
                + ", product_quantity=" + product_quantity + ", product_price=" + product_price + "]";
    }
}
