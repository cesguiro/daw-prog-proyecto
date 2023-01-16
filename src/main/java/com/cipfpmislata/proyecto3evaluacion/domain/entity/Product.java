package com.cipfpmislata.proyecto3evaluacion.domain.entity;

public class Product {
    
    private int id;
    private String brand;
    private String name;
    private String description;
    private double price;
    private int category_id;
    
    public Product(int id, String brand, String name, String description, double price, int category_id) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    public int getCategory_id() {
        return category_id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", brand=" + brand + ", name=" + name + ", description=" + description + ", price="
                + price + ", category_id=" + category_id + "]";
    }

    
}
