package com.lwt.bookstore_be.daoimpl;

import com.lwt.bookstore_be.dao.CartDao;
import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartEntity> getCartByUserId(Integer user_id) {
        return cartRepository.getCartEntitiesByUserId(user_id);
    }

    @Override
    public void addIntoCart(CartEntity cartEntity) {
        cartRepository.save(cartEntity);
    }

    @Override
    public CartEntity findCartByUser_BookId(Integer user_id, Integer book_id) {
        return cartRepository.getCartEntityByUserIdAndBookId(user_id,book_id);
    }

    @Override
    public CartEntity findOne(Integer id) {
        return cartRepository.getOne(id);
    }

    @Override
    public List<CartEntity> getCartByOrderId(String orderId) {
        return cartRepository.getCartEntitiesByOrderId(orderId);
    }


}
