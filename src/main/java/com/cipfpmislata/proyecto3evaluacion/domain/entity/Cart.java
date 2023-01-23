package com.cipfpmislata.proyecto3evaluacion.domain.entity;

import java.util.List;

public class Cart {
    
    private List<Article> articles;

    public Cart(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
