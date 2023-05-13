package com.lwt.bookstore_be.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwt.bookstore_be.dto.CartItem;
import com.lwt.bookstore_be.dto.OrderItem;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.entity.OrdersEntity;
import com.lwt.bookstore_be.repository.BookRepository;
import com.lwt.bookstore_be.repository.CartRepository;
import com.lwt.bookstore_be.service.BookService;
import com.lwt.bookstore_be.service.CartService;
import com.lwt.bookstore_be.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
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

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;


    @RequestMapping("/getOrder")
    public List<OrderItem> getOrder(@RequestParam("id") Integer id){
        ArrayList<OrderItem> ret = new ArrayList<OrderItem>();

        List<OrdersEntity> orders = orderService.getOrdersByUserId(id);
        for (OrdersEntity ordersEntity : orders) {
            ArrayList<String> bookTitles = new ArrayList<String>();
            List<CartEntity> cartsInOrder = cartService.findCartByOrderId(ordersEntity.getId());
            for (CartEntity cartEntity : cartsInOrder) {
              bookTitles.add(bookService.findBookById(cartEntity.getBookId()).getName());
            }
            OrderItem orderItem = new OrderItem(ordersEntity,bookTitles);
            ret.add(orderItem);

        }
        return ret;
    }

    @RequestMapping("/getAllOrder")
    public List<OrderItem> getAllOrder(@RequestBody Map<String, String> params){
        ArrayList<OrderItem> ret = new ArrayList<OrderItem>();

        List<OrdersEntity> orders = orderService.getAllOrders();
        for (OrdersEntity ordersEntity : orders) {
            ArrayList<String> bookTitles = new ArrayList<String>();
            List<CartEntity> cartsInOrder = cartService.findCartByOrderId(ordersEntity.getId());
            for (CartEntity cartEntity : cartsInOrder) {
                bookTitles.add(bookService.findBookById(cartEntity.getBookId()).getName());
            }
            OrderItem orderItem = new OrderItem(ordersEntity,bookTitles);
            ret.add(orderItem);

        }
        return ret;
    }



    @RequestMapping("/addOrder")
    public void addOrder( @RequestBody Map<String, Object> map){

            Integer userId = Integer.parseInt(map.get("user_id").toString());
//            Integer bookId = Integer.parseInt(map.get("book_id"));

            //Set OrderID
            String orderId = map.get("orderId").toString();
            Object books = map.get("books");
            JSONArray jsonArray = JSONArray.fromObject(books);
            System.out.print(jsonArray);
            for(int i=0;i<jsonArray.size();i++) {
                Integer cartId= Integer.parseInt(jsonArray.getJSONObject(i).get("cartId").toString());
                CartEntity cartEntity= cartService.findCartByCartId(cartId);
                cartEntity.setOrderId(orderId);
                cartRepository.save(cartEntity);

                Integer number = Integer.parseInt(jsonArray.getJSONObject(i).get("number").toString());

                //TODO if inventory < 0
                Integer bookId = Integer.parseInt(jsonArray.getJSONObject(i).get("bookId").toString());
                BookEntity bookEntity = bookService.findBookById(bookId);
                bookEntity.setInventory(bookEntity.getInventory()-number);
                bookRepository.save(bookEntity);

            }

            String name = map.get("username").toString();
//            String addr = map.get("addr");
            BigDecimal totalPrice = BigDecimal.valueOf(Double.parseDouble(map.get("totalPrice").toString()));

            Timestamp time = Timestamp.valueOf(map.get("time").toString());

            OrdersEntity ordersEntity = new OrdersEntity();
            ordersEntity.setUserId(userId);
            ordersEntity.setName(name);
            ordersEntity.setId(orderId);
            ordersEntity.setTotalPrice(totalPrice);
            ordersEntity.setTime(time);

            orderService.addOrder(ordersEntity);

        }



    }
