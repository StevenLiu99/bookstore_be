package com.lwt.bookstore_be.repository;

import com.lwt.bookstore_be.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    @Query("select b from BookEntity b")
    List<BookEntity> getBooks();
}

