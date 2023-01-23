package com.cipfpmislata.proyecto3evaluacion.domain.service.impl;

import com.cipfpmislata.proyecto3evaluacion.domain.entity.Cart;
import com.cipfpmislata.proyecto3evaluacion.domain.service.OrderService;
import com.cipfpmislata.proyecto3evaluacion.persistence.CartRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.OrderRepository;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.CartRepositoryImplJDBC;
import com.cipfpmislata.proyecto3evaluacion.persistence.impl.OrderRepositoryImplJDBC;

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository = new OrderRepositoryImplJDBC();
    private CartRepository cartRepository = new CartRepositoryImplJDBC();

    @Override
    public void create(Cart cart) {
        //Crear el pedido y las líneas de pedido
        //Borrar los productos del carrito del usuario
    }
    
}
