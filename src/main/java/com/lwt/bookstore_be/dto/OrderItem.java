package com.lwt.bookstore_be.dto;

import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.entity.OrdersEntity;
import com.lwt.bookstore_be.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItem {


    private List<String> BookTitles;
    private String orderID;
    private BigDecimal totalPrice;
    private String username;
    private Date time;

    public OrderItem(OrdersEntity ordersEntity,ArrayList<String> bookTitles){
        this.BookTitles = bookTitles;
        this.orderID = ordersEntity.getId();
        this.totalPrice=ordersEntity.getTotalPrice();
        this.time =ordersEntity.getTime();
        this.username = ordersEntity.getName();

    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public String getOrderID() {
        return orderID;
    }

    public List<String> getBookTitles() {
        return BookTitles;
    }

    public String getUsername() {
        return username;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setBookTitles(List<String> bookTitles) {
        BookTitles = bookTitles;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
