package com.lwt.bookstore_be.service;

import com.lwt.bookstore_be.entity.OrdersEntity;

import java.util.List;

public interface OrderService {

    List<OrdersEntity> getOrdersByUserId(Integer user_id);
    List<OrdersEntity> getAllOrders();
    void  addOrder (OrdersEntity orderEntity);

}
