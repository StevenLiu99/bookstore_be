package com.lwt.bookstore_be.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "bookstore", catalog = "")
public class UserEntity {
    private int userId;
    private String nickname;
    private String name;
    private String tel;
    private String address;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && Objects.equals(nickname, that.nickname) && Objects.equals(name, that.name) && Objects.equals(tel, that.tel) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickname, name, tel, address);
    }
}
