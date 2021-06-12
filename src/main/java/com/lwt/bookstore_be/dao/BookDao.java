package com.lwt.bookstore_be.dao;

import com.lwt.bookstore_be.entity.BookEntity;

import java.util.List;

public interface BookDao {
    BookEntity findOne(Integer id);
    List<BookEntity> getBooks();
    void updateOne(BookEntity bookEntity);
    void deleteOne(Integer id);

}
