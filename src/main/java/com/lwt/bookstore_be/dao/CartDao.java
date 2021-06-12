package com.lwt.bookstore_be.dao;

import com.lwt.bookstore_be.entity.CartEntity;

import java.util.List;

public interface CartDao {
    List<CartEntity> getCartByUserId(Integer user_id);
    void addIntoCart(CartEntity cartEntity);
}
