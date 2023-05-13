package com.lwt.bookstore_be.serviceimpl;

import com.lwt.bookstore_be.dao.OrderDao;
import com.lwt.bookstore_be.entity.OrdersEntity;
import com.lwt.bookstore_be.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrdersEntity> getOrdersByUserId(Integer user_id) {
        return orderDao.getOrderByUserId(user_id);
    }

    @Override
    public List<OrdersEntity> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public void addOrder(OrdersEntity ordersEntity) {
        orderDao.addOrder(ordersEntity);
    }
}
