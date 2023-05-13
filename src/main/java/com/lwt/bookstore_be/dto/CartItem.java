package com.lwt.bookstore_be.dto;

import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.CartEntity;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

public class CartItem {
    private Integer key;
    private String bookTitle;
    private Integer bookId;
    private Integer cartId;
    private Integer number;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String img;


    public CartItem(BookEntity bookEntity, CartEntity cartEntity,Integer key){
        this.key = key;
        this.bookId = bookEntity.getId();
        this.bookTitle = bookEntity.getName();
        this.img=bookEntity.getImage();
        this.number = cartEntity.getNumber();
        this.cartId = cartEntity.getId();
        this.price = bookEntity.getPrice();
        this.totalPrice = BigDecimal.valueOf(number).multiply(this.price) ;
    }

    public CartItem() {
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookTitle(){
        return  this.bookTitle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public String getImg() {
        return img;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
