package com.cipfpmislata.proyecto3evaluacion.domain.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private String user_id;
    private Date date;
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order(int id, String user_id, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", user_id=" + user_id + ", date=" + date + "]";
    }
}
