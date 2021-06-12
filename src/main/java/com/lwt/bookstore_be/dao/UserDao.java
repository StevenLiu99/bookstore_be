package com.lwt.bookstore_be.dao;

import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.entity.UserEntity;

import java.util.List;

public interface UserDao {
    UserAuthEntity checkUser(String username, String password);
    UserAuthEntity findUserByName(String username);
    void appendUserAuth(UserAuthEntity userAuthEntity);
    void appendUser(UserEntity userEntity);
    List<UserAuthEntity> getAllUsers();
    void setUserState(String username, Integer state);
}
