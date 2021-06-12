package com.lwt.bookstore_be.service;


import com.lwt.bookstore_be.entity.CartEntity;

import java.util.List;

public interface CartService {
    List<CartEntity> findCartById(Integer user_id);

    void addIntoCart(CartEntity cartEntity);
}
