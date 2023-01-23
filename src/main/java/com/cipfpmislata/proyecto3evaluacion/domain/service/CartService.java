package com.cipfpmislata.proyecto3evaluacion.domain.service;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Article;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;

public interface CartService {
    
    public void addArticle(Article article);
    public Cart getByUserId(String user_id);
    public boolean deleteArticle(int article_id, String user_id);

}
