package com.lwt.bookstore_be.service;

import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.entity.UserEntity;
import com.lwt.bookstore_be.exception.MyException;

import java.util.List;

public interface UserService {
    UserAuthEntity checkUser(String username,String password);
    Boolean Register(String username, String password, String nickname, String telephone, String address) throws MyException;
    List<UserAuthEntity> getUsers();
    Boolean setUserState(String username,Integer userState);
}
