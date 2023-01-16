package com.cipfpmislata.proyecto3evaluacion.domain.entity;

public class Category {
    
    private int id;
    private String name;
    private String image;
    
    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Categoría [id=" + id + ", nombre=" + name + "]";
    }

}
