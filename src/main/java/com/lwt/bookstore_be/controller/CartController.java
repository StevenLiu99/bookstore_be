package com.lwt.bookstore_be.controller;

import com.lwt.bookstore_be.dto.CartItem;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.service.BookService;
import com.lwt.bookstore_be.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;


    @RequestMapping("/getCart")
    public ArrayList<CartItem> getCart(@RequestParam("id") Integer id) {
        List<CartEntity> cart = cartService.findCartById(id);

        ArrayList<CartItem> ret = new ArrayList<CartItem>();
        Integer key = 0;
        for (CartEntity cartEntity : cart) {
            BookEntity bookEntity = bookService.findBookById(cartEntity.getBookId());
            CartItem cartItem = new CartItem(bookEntity, cartEntity,key);
            key=key+1;
            ret.add(cartItem);
        }
        return ret;
    }

    @RequestMapping("/addIntoCart")
    public void addIntoCart(@RequestBody Map<String, String> map){
        int user_id = Integer.parseInt(map.get("user_id"));
        int book_id = Integer.parseInt(map.get("book_id"));
        CartEntity cartEntity =new CartEntity();
        cartEntity.setBookId(book_id);
        cartEntity.setUserId(user_id);
        cartEntity.setNumber(1);
        cartEntity.setOrderId(0);
        cartEntity.setState(0);


        cartService.addIntoCart(cartEntity);
    }

}
