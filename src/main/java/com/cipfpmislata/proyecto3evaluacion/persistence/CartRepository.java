package com.cipfpmislata.proyecto3evaluacion.persistence;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Article;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;

public interface CartRepository {
    
    public boolean addArticle(Article article);
    public Cart getByUserId(String user_id);
    public boolean deleteArticle(int article_id, String user_id);
}
