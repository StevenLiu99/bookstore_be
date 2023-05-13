package com.lwt.bookstore_be.serviceimpl;

import com.lwt.bookstore_be.dao.CartDao;
import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public List<CartEntity> findCartById(Integer user_id) {
        return cartDao.getCartByUserId(user_id);
    }

    @Override
    public CartEntity findCartByUser_BookId(Integer user_id, Integer book_id) {
        return cartDao.findCartByUser_BookId(user_id,book_id);
    }

    @Override
    public void addIntoCart(CartEntity cartEntity) {
        cartDao.addIntoCart(cartEntity);
    }

    @Override
    public CartEntity findCartByCartId(Integer id) {
        return cartDao.findOne(id);
    }

    @Override
    public List<CartEntity> findCartByOrderId(String id) {
        return cartDao.getCartByOrderId(id);
    }


}
