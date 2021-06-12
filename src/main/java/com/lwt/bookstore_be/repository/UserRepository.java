package com.lwt.bookstore_be.repository;

import com.lwt.bookstore_be.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,String> {
}
