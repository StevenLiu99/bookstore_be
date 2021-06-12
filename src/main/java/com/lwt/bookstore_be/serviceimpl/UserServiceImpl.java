package com.lwt.bookstore_be.serviceimpl;

import com.lwt.bookstore_be.dao.UserDao;
import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.entity.UserEntity;
import com.lwt.bookstore_be.exception.MyException;
import com.lwt.bookstore_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserAuthEntity checkUser(String username, String password) {
        return userDao.checkUser(username,password);
    }

    @Override
    public Boolean Register(String username, String password, String nickname, String telephone, String address)throws MyException {
        UserEntity userEntity = new UserEntity();
        System.out.println("User Registering...");
        UserAuthEntity userAuthEntity = new UserAuthEntity();
        if(userDao.findUserByName(username)!=null){
            throw new MyException(12,"用户名重复");
        }
        userAuthEntity.setUsername(username);
//        userAuthEntity.setUserType(user_type);
        userAuthEntity.setPassword(password);
        userDao.appendUserAuth(userAuthEntity);

        userEntity.setName(username);
        userEntity.setAddress(address);
        userEntity.setNickname(nickname);
        userEntity.setTel(telephone);
        userDao.appendUser(userEntity);
        System.out.println("User Registered");

        return true;
    }

    @Override
    public List<UserAuthEntity> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Boolean setUserState(String username, Integer userState) {
        userDao.setUserState(username,userState);
        return true;
    }


}
