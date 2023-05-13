package com.lwt.bookstore_be.service;


import com.lwt.bookstore_be.entity.CartEntity;

import java.util.List;

public interface CartService {
    List<CartEntity> findCartById(Integer user_id);
    CartEntity findCartByUser_BookId(Integer user_id,Integer book_id);
    void addIntoCart(CartEntity cartEntity);
    CartEntity findCartByCartId(Integer id);
    List<CartEntity> findCartByOrderId(String id);
}
