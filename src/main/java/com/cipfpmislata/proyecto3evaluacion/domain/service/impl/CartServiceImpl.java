package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Article;
import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;
import com.cipfpmislata.proyecto3evaluacion.domain.service.CartService;
import com.cipfpmislata.proyecto3evaluacion.persistence.CartRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.CartRepositoryImplJDBC;

public class CartServiceImpl implements CartService{

    private CartRepository cartRepository = new CartRepositoryImplJDBC();

    @Override
    public void addArticle(Article article) {
        cartRepository.addArticle(article);
        
    }

    @Override
    public Cart getByUserId(String user_id) {
        return cartRepository.getByUserId(user_id);
    }

    @Override
    public boolean deleteArticle(int article_id, String user_id) {
        return cartRepository.deleteArticle(article_id, user_id);
    }
    
}
