package com.lwt.bookstore_be.repository;

import com.lwt.bookstore_be.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAuthRepository extends JpaRepository<UserAuthEntity,String> {
    @Query(value = "from UserAuthEntity where username = :username and password = :password")
    UserAuthEntity checkUser(@Param("username") String username, @Param("password") String password);

    @Query("select u from UserAuthEntity u where u.username = :username")
    UserAuthEntity findUserByName(@Param("username") String username);

    @Query("select u from UserAuthEntity u")
    List<UserAuthEntity> getUsers();
}
