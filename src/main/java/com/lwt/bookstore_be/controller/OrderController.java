package com.lwt.bookstore_be.controller;


import com.lwt.bookstore_be.dto.CartItem;
import com.lwt.bookstore_be.entity.OrdersEntity;
import com.lwt.bookstore_be.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping("/getOrder")
    public List<OrdersEntity> getOrder(@RequestParam("id") Integer id){
        return orderService.getOrdersByUserId(id);
    }

    @RequestMapping("/addOrder")
    public void addOrder(@RequestBody Map<String, String> map){

         Integer userId = Integer.parseInt(map.get("user_id"));
         String name = map.get("username");
         String addr = map.get("addr");
         BigDecimal totalPrice = BigDecimal.valueOf(Double.parseDouble(map.get("totalPrice")));
         Integer state = Integer.parseInt(map.get("state"));
         Timestamp time = Timestamp.valueOf(map.get("time"));

         OrdersEntity ordersEntity = new OrdersEntity();
         ordersEntity.setUserId(userId);
         ordersEntity.setAddr(addr);
         ordersEntity.setName(name);
         ordersEntity.setState(state);
         ordersEntity.setTotalPrice(totalPrice);
         ordersEntity.setTime(time);

        orderService.addOrder(ordersEntity);

    }

}
