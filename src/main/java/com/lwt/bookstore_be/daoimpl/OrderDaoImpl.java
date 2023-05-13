package com.lwt.bookstore_be.daoimpl;

import com.lwt.bookstore_be.dao.OrderDao;

import com.lwt.bookstore_be.entity.OrdersEntity;
import com.lwt.bookstore_be.repository.CartRepository;
import com.lwt.bookstore_be.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrdersEntity> getOrderByUserId(Integer user_id) {
        return orderRepository.getOrdersEntitiesByUserId(user_id);
    }

    @Override
    public void addOrder(OrdersEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrdersEntity> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
