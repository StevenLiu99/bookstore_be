package com.lwt.bookstore_be.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "bookstore", catalog = "")
@IdClass(CartEntityPK.class)
public class CartEntity {
    private int userId;
    private int bookId;
    private Integer number;
    private Integer orderId;
    private Integer state;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return userId == that.userId && bookId == that.bookId && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId, number);
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
