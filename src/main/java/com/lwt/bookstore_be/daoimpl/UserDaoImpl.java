package com.lwt.bookstore_be.daoimpl;

import com.lwt.bookstore_be.dao.UserDao;
import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.entity.UserEntity;
import com.lwt.bookstore_be.repository.UserAuthRepository;
import com.lwt.bookstore_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserAuthEntity checkUser(String username, String password) {
        return userAuthRepository.checkUser(username,password);
    }

    @Override
    public UserAuthEntity findUserByName(String username) {
        return userAuthRepository.findUserByName(username);
    }

    @Override
    public void appendUserAuth(UserAuthEntity userAuthEntity) {
        userAuthRepository.save(userAuthEntity);
    }

    @Override
    public void appendUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public List<UserAuthEntity> getAllUsers() {
        return userAuthRepository.getUsers();
    }

    @Override
    public void setUserState(String username, Integer state) {
        UserAuthEntity userAuthEntity = userAuthRepository.findUserByName(username);
        userAuthEntity.setUserState(state);
        userAuthRepository.save(userAuthEntity);

    }


}
