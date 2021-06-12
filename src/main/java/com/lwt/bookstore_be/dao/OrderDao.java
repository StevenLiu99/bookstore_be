package com.lwt.bookstore_be.dao;


import com.lwt.bookstore_be.entity.OrdersEntity;

import java.util.List;

public interface OrderDao {
    List<OrdersEntity> getOrderByUserId(Integer user_id);
    void addOrder(OrdersEntity orderEntity);
}
