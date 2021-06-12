package com.lwt.bookstore_be.repository;


import com.lwt.bookstore_be.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrdersEntity,Integer> {
    @Query("select o from OrdersEntity o where o.userId =?1")
    List<OrdersEntity> getOrdersEntitiesByUserId(Integer userid);
}
