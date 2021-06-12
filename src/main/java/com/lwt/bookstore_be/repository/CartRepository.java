package com.lwt.bookstore_be.repository;

import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.entity.CartEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, CartEntityPK> {

    @Query("select c from CartEntity c where c.userId =?1")
    List<CartEntity> getCartEntitiesByUserId(Integer userid);
}
