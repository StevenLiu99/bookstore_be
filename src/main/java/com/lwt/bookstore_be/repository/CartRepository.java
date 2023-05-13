package com.lwt.bookstore_be.repository;

import com.lwt.bookstore_be.entity.CartEntity;
import com.lwt.bookstore_be.entity.CartEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

    @Query("select c from CartEntity c where c.userId =?1")
    List<CartEntity> getCartEntitiesByUserId(Integer userid);

    @Query("from CartEntity where userId = :userid and bookId = :bookid and orderId is null")
    CartEntity getCartEntityByUserIdAndBookId(@Param("userid") Integer userid, @Param("bookid") Integer bookid);

//    @Query("from CartEntity where userId = :userid and bookId = :bookid and orderId is null ")
//    CartEntity getCartEntityByIdsAndOrderIsNull(@Param("userid") Integer userid, @Param("bookid") Integer bookid);

    @Query("from CartEntity where orderId = :orderid")
    List<CartEntity> getCartEntitiesByOrderId(@Param("orderid")String orderid);
}
