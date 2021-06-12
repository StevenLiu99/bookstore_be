package com.lwt.bookstore_be.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_auth", schema = "bookstore", catalog = "")
public class UserAuthEntity {
    private int userId;
    private String username;
    private String password;
    private int userType;
    private int userState;


    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_type")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_state")
    public int getUserState() {
        return userState;
    }
    public void setUserState(int userState) {
        this.userState = userState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthEntity that = (UserAuthEntity) o;
        return userId == that.userId && userType == that.userType && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, userType);
    }
}
